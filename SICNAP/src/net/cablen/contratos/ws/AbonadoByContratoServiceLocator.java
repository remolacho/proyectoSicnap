/**
 * AbonadoByContratoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.cablen.contratos.ws;

public class AbonadoByContratoServiceLocator extends org.apache.axis.client.Service implements net.cablen.contratos.ws.AbonadoByContratoService {

    public AbonadoByContratoServiceLocator() {
    }


    public AbonadoByContratoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AbonadoByContratoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AbonadoByContrato
    private java.lang.String AbonadoByContrato_address = "http://200.47.182.77:8080/wsAboByContrato/services/AbonadoByContrato";

    public java.lang.String getAbonadoByContratoAddress() {
        return AbonadoByContrato_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AbonadoByContratoWSDDServiceName = "AbonadoByContrato";

    public java.lang.String getAbonadoByContratoWSDDServiceName() {
        return AbonadoByContratoWSDDServiceName;
    }

    public void setAbonadoByContratoWSDDServiceName(java.lang.String name) {
        AbonadoByContratoWSDDServiceName = name;
    }

    public net.cablen.contratos.ws.AbonadoByContrato getAbonadoByContrato() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AbonadoByContrato_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAbonadoByContrato(endpoint);
    }

    public net.cablen.contratos.ws.AbonadoByContrato getAbonadoByContrato(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.cablen.contratos.ws.AbonadoByContratoSoapBindingStub _stub = new net.cablen.contratos.ws.AbonadoByContratoSoapBindingStub(portAddress, this);
            _stub.setPortName(getAbonadoByContratoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAbonadoByContratoEndpointAddress(java.lang.String address) {
        AbonadoByContrato_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.cablen.contratos.ws.AbonadoByContrato.class.isAssignableFrom(serviceEndpointInterface)) {
                net.cablen.contratos.ws.AbonadoByContratoSoapBindingStub _stub = new net.cablen.contratos.ws.AbonadoByContratoSoapBindingStub(new java.net.URL(AbonadoByContrato_address), this);
                _stub.setPortName(getAbonadoByContratoWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AbonadoByContrato".equals(inputPortName)) {
            return getAbonadoByContrato();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "AbonadoByContratoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "AbonadoByContrato"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AbonadoByContrato".equals(portName)) {
            setAbonadoByContratoEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
