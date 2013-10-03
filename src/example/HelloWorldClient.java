package example;

import com.sun.jndi.rmi.registry.RemoteReference;
import mypacakge.HelloWorldServiceLocator;
import mypacakge.HelloWorld_PortType;

import javax.swing.*;
import javax.xml.rpc.ServiceException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: 045B
 * Date: 03.10.13
 * Time: 4:28
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldClient {
  public static void main(String[] argv) {
//      try {
          JFrame frame = new JFrame();
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
          JButton button = new JButton("Press");
          button.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  HelloWorldServiceLocator locator = new HelloWorldServiceLocator();
                  HelloWorld_PortType service = null;
                  try {
                      service = locator.getHelloWorld();
                  // If authorization is required
                  //((HelloWorldSoapBindingStub)service).setUsername("user3");
                  //((HelloWorldSoapBindingStub)service).setPassword("pass3");
                  // invoke business method
                  String response = service.sayHelloWorldFrom("John");
                  System.out.println(response);
                  } catch (ServiceException e1) {
                      e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                  } catch (RemoteException e1) {
                      e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                  }
              }
          });
          frame.add(button);


      /*} catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      } */
  }
}