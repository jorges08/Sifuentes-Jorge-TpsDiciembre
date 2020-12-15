/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
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
public class Tp3Ficheros {
    static PrintStream ps  =  new PrintStream (System.out);
    static Document doc  =  new Document();
    static Element root  =   new Element("ferreteria");
    static BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));     
    public static void main(String[] args) throws IOException, JDOMException {
        ps.println("Menu");
        ps.println("1-Ingresar proveedores");
        ps.println("2-Ingresar stock");
        ps.println("3-Ingresar clientes");
        ps.println("4-Ingresar ventas");
        String opS   =   br.readLine();
        int op  =  Integer.parseInt(opS);
        while(op <= 5 && op >= 1){
            switch(op){
                case 1: proveedoresXML();
                    break;
                case 2: stockXML();
                    break;
                case 3: clientesXML();
                    break;
                case 4: ventasXML();
                    break;
                case 5: mostrar();
                    break;  
                default: ps.println("Numero incorrecto, intente de nuevo");
            }
        }    
    }

    private static void proveedoresXML() throws IOException {
        File archivo = new File("proveedoresXML.xml");
        
        FileWriter fw=new FileWriter(archivo,true);
        
        PrintWriter pw=new PrintWriter(fw);
        
        doc.setRootElement(root);
        
        Element proveedores  =  new Element("proveedores"
                + "");
        ps.println("Ingrese id proveedor");
        
        String id_proveedor  =  br.readLine();
        
        ps.println("Ingrese nombre de la empresa");
        
        String nombre_empresa  =  br.readLine();
        
        ps.println("Ingrese el material");
        
        String materiales  =  br.readLine();
        
        ps.println("Ingrese el precio del material");
        
        String precio_material  =  br.readLine();
        
        ps.println("Ingrese la descripcion del material");
        
        String descripcion_material  =  br.readLine();
        
        proveedores.addContent(
                                new Element("id_proveedor").setText(id_proveedor)        
                                );
        proveedores.addContent(
                                new Element("nombre_empresa").setText(nombre_empresa)                                
                                );    
        proveedores.addContent(
                                new Element("materiales").setText(materiales)        
                                );
        proveedores.addContent(
                                new Element("precio_material").setText(precio_material)        
                                );
        proveedores.addContent(
                                new Element("descripcion_material").setText(descripcion_material)        
                                );
        doc.getRootElement().addContent(proveedores);
        XMLOutputter salidaXML=new XMLOutputter();
        salidaXML.setFormat(Format.getPrettyFormat());
        salidaXML.output(doc, new FileWriter("proveedoresXML.xml"));
    }

    private static void stockXML() throws IOException {
        
        Element proveedores=new Element("stock");
        
        
        ps.println("Ingrese id del producto");
        
        
        String id_producto=br.readLine();
        
        ps.println("Ingrese id del proveedor");
        
        
        String id_proveedor=br.readLine();
        ps.println("Ingrese nombre del producto");
        
        String nombre_producto=br.readLine();
        
        ps.println("Ingrese descripcion del producto");
        
        String descripcion_producto=br.readLine();
        
        ps.println("Ingrese el precio de venta ");
        
        String precio_venta=br.readLine();
        
        ps.println("Ingrese precio de compra");
        
        String precio_compra=br.readLine();
        
        ps.println("Ingrese cantidad del producto");
        
        String cantidad_producto=br.readLine();
        
        
        proveedores.addContent(
                                new Element("id_producto").setText(id_producto)        
                                );
        proveedores.addContent(
                                new Element("id_proveedor").setText(id_proveedor)                                
                                );    
        proveedores.addContent(
                                new Element("nombre_producto").setText(nombre_producto)        
                                );
        proveedores.addContent(
                                new Element("descripcion_producto").setText(descripcion_producto)        
                                );
        proveedores.addContent(
                                new Element("precio_venta").setText(precio_venta)        
                                );
        proveedores.addContent(
                                new Element("precio_compra").setText(precio_compra)        
                                );
        proveedores.addContent(
                                new Element("cantidad_producto").setText(cantidad_producto)        
                                );
    }

    private static void clientesXML() throws IOException {
        Element proveedores  =  new Element("clientes");
        ps.println("Ingrese id del cliente");
        String id_cliente=br.readLine();
        ps.println("Ingrese nombre del cliente");
        String nombre_cliente  =  br.readLine();
        ps.println("Ingrese apellido del cliente");
        String apellido_cliente = br.readLine();
        ps.println("Ingrese tipo de consumidor");
        String tipo_consumidor  =  br.readLine();
        ps.println("Ingrese cuil/cuilt del cliente");
        String cuil_cuilt  =  br.readLine();
        ps.println("Ingrese ultima compra del cliente");
        String ultima_compra  =  br.readLine();
        proveedores.addContent(
                    new Element("id_cliente").setText(id_cliente)        
                                );
        proveedores.addContent(
                      new Element("nombre_cliente").setText(nombre_cliente)                                
                                );    
        proveedores.addContent(
                      new Element("apellido_cliente").setText(apellido_cliente)        
                                );
        proveedores.addContent(
                       new Element("tipo_consumidor").setText(tipo_consumidor)        
                                );
        proveedores.addContent(
                        new Element("cuil_cuilt").setText(cuil_cuilt)        
                                );
        proveedores.addContent(
                           new Element("ultima_compra").setText(ultima_compra)        
                                );
    }

    private static void ventasXML() throws IOException {
        Element proveedores  =  new Element("ventas");
        ps.println("Ingrese id de venta");
        String id_venta=br.readLine();
        ps.println("Ingrese id del cliente");
        String id_cliente  =  br.readLine();
        ps.println("Ingrese id del producto");
        String id_producto=br.readLine();
        ps.println("Ingrese nombre del producto");
        String nombre_producto = br.readLine();
        ps.println("Ingrese precio de venta");
        String precio_venta  =  br.readLine();
        ps.println("Ingrese la cantidad del producto");
        String cantidad_producto=br.readLine();
        proveedores.addContent(
                             new Element("id_venta").setText(id_venta)        
                                );
        proveedores.addContent(
                            new Element("id_cliente").setText(id_cliente)                                
                                );    
        proveedores.addContent(
                            new Element("id_producto").setText(id_producto)        
                                );
        proveedores.addContent(
                           new Element("nombre_producto").setText(nombre_producto)        
                                );
        proveedores.addContent(
                                new Element("precio_venta").setText(precio_venta)        
                           );
        proveedores.addContent(
                             new Element("cantidad_producto").setText(cantidad_producto)        
                                );
    }

    private static void mostrar() {
        SAXBuilder constructor=new SAXBuilder();
        try {
            Document d  =  (Document)constructor.build("proveedoresXML.xml");
            Element r   =  d.getRootElement();
            List<Element> lista  =  r.getChildren("proveedores");
            for(Element item:lista){
                ps.println(item.getName()+"\t"+item.getValue()+"\t");
            }
        } catch (JDOMException ex) {
            Logger.getLogger(Tp3Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
