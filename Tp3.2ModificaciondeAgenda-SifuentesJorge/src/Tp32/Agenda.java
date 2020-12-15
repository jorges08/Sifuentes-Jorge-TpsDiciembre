/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp32;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Dani
 */
public class Agenda {
    
    static File Agenda = new File("agenda.xml");
    static File Agendatemp = new File("agendaAux.xml");
    
    public static void main(String[] args) throws IOException, JDOMException {
        
        iniciar();
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        PrintStream ps = new PrintStream (System.out);
        int opcion = 3;
        while(opcion <= 3 && opcion >= 1){
            ps.println("--->Menu<---");
            ps.println("Eliga la opcion ingresando la letra correspondiente.");
            ps.println("|* Agregar   -  1 *|");
            ps.println("|* Eliminar  -  2 *|");
            ps.println("|* Mostrar   -  3 *|");
            ps.println("|* Salir     -  4 *|");
            
            opcion = Integer.parseInt(br.readLine());
            
            switch(opcion){
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    eliminarContacto();
                    break;
                case 3:
                    mostrarAgenda();
                    break;
                default:
                    System.out.println("\n\nSaliendo...!");
            }
        }
    }
    
    public static void iniciar(){
        if(Agenda.length()==0){
            Document doc = new Document();
            Element root = new Element("Agenda");
            doc.setRootElement(root);
            try {
                XMLOutputter salidaXML = new XMLOutputter();
                salidaXML.setFormat(Format.getPrettyFormat());
                salidaXML.output(doc, new FileWriter(Agenda,false));
            } catch (IOException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Agendatemp.length()==0){
            Document doc = new Document();
            Element root = new Element("Agenda");
            doc.setRootElement(root);
            try {
                XMLOutputter salidaXML = new XMLOutputter();
                salidaXML.setFormat(Format.getPrettyFormat());
                salidaXML.output(doc, new FileWriter(Agendatemp,false));
            } catch (IOException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static void agregarContacto() throws IOException{
        String[] valor = new String[5];
        String valorString = "";
        String datos = "";
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br1 = new BufferedReader(reader);
        FileWriter fw = new FileWriter(Agenda,true);
        PrintWriter pw = new PrintWriter(fw);
        PrintStream ps = new PrintStream(System.out);

        
        
        try {

            while(valorString.split(" ").length != 5 && !datos.trim().equals("salir")){
                ps.println("\nIngrese los datos del contacto, separados por un espacio en blanco, de la siguiente manera ( - id - nombre - apellido - telefono - email -)[Si desea salir ingrese \"salir\"]: ");
                datos = br1.readLine();
                if(datos.split(" ").length == 5 && !datos.trim().equals("salir"))valorString = datos;
                valor = valorString.split(" ");
                if(valorString.split(" ").length != 5 && !datos.trim().equals("salir")){
                    ps.println("\nAlgo esta mal.Ingrese nuevamente\n");
                }
            }
            
            if(!datos.trim().equals("salir")){
                SAXBuilder constructor = new SAXBuilder();
                Document doc;
                doc = (Document) constructor.build(Agenda);
            
                Element con = new Element("Contacto");
                con.setAttribute(new Attribute("id", valor[0]));
                con.addContent(new Element("nombre").setText(valor[1]));
                con.addContent(new Element("apellido").setText(valor[2]));
                con.addContent(new Element("telefono").setText(valor[3]));
                con.addContent(new Element("mail").setText(valor[4]));

                doc.getRootElement().addContent(con);

                XMLOutputter salidaXML = new XMLOutputter();
                salidaXML.setFormat(Format.getPrettyFormat());
                salidaXML.output(doc, new FileWriter(Agenda));
                
                System.out.println("\nEl contacto se ah agregado exitosamente\n" + getContacto(valor[0]));
            }
        } catch (JDOMException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private static void pasarAgenda() throws IOException{
        
        FileWriter fw = new FileWriter(Agenda, false);
        PrintWriter pw = new PrintWriter(fw);
        Scanner sc = new Scanner(Agendatemp);
     
            while(sc.hasNextLine()){
                pw.println(sc.nextLine());
            }
            
            pw.flush();
            pw.close();
            fw.close();
            sc.close();

    }
    
    private static void eliminarContacto() throws IOException, JDOMException{
        FileWriter fw = new FileWriter(Agendatemp, false);
        PrintWriter pw;
        Scanner scan = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out);

        String id;
        
            iniciar();

            ps.println("\n Id del usuario a eliminar [Si desea salir, ingrese \"salir\"]:\n");
            id = scan.next();
            
            if(!id.equals("salir")){
                SAXBuilder constructor = new SAXBuilder();
                Document doc = (Document) constructor.build(Agenda);
                Document doc2 = (Document) constructor.build(Agendatemp);
                List<Element> ele = doc.getRootElement().getChildren("Contacto");
                
                for(Element cont : ele){
                    Attribute a = cont.getAttribute("id");
                    
                    if(!a.getValue().equals(id)) {
                        Element contacto = new Element("Contacto");
                        contacto.setAttribute(new Attribute("id", cont.getAttribute("id").getValue()));
                        contacto.addContent(new Element("nombre").setText(cont.getChildText("nombre")));
                        contacto.addContent(new Element("apellido").setText(cont.getChildText("apellido")));
                        contacto.addContent(new Element("telefono").setText(cont.getChildText("telefono")));
                        contacto.addContent(new Element("mail").setText(cont.getChildText("mail")));

                        doc2.getRootElement().addContent(contacto);
                        
                    }
                    
                }
                
                XMLOutputter salidaXML = new XMLOutputter();
                salidaXML.setFormat(Format.getPrettyFormat());
                salidaXML.output(doc2, new FileWriter(Agendatemp));
                pasarAgenda();
            }
    }
            
    private static void mostrarAgenda(){
        SAXBuilder constructor = new SAXBuilder();
        PrintStream ps = new PrintStream(System.out);

        try {
            Document doc = (Document) constructor.build(Agenda);
            Element root = doc.getRootElement();
            List<Element> ele = root.getChildren("Contacto");
            ps.println("\n[LISTA DE CONTACTOS]\n");
            for(Element item : ele){ 
                ps.println("\nID: "+item.getAttribute("id").getValue()+
                       "\tNombre: "+item.getChildText("nombre")+
                       "\tApellido: "+item.getChildText("apellido")+
                       "\tTelefono: "+item.getChildText("telefono")+
                       "\tMail: "+item.getChildText("mail")+"\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException | IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static String getContacto(String id){
        SAXBuilder constructor = new SAXBuilder();
        
        try {
            Document doc = (Document) constructor.build(Agenda);
            Element root = doc.getRootElement();
            List<Element> ele = root.getChildren("Contacto");
            for(Element item : ele){
                if(item.getAttribute("id").getValue().equals(id)){
                    return "\nID: "+item.getAttribute("id").getValue()+
                           "\tNombre: "+item.getChildText("nombre")+
                           "\tApellido: "+item.getChildText("apellido")+
                           "\tTelefono: "+item.getChildText("telefono")+
                           "\tMail: "+item.getChildText("mail")+"\n";
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException | IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "\nNo se pudo encontrar el contacto";
    }
    
}
