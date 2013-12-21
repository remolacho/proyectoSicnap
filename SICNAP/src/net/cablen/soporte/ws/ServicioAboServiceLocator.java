/**
 * ServicioAboServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.cablen.soporte.ws;

public class ServicioAboServiceLocator extends org.apache.axis.client.Service implements net.cablen.soporte.ws.ServicioAboService {

    public ServicioAboServiceLocator() {
    }


    public ServicioAboServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioAboServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioAbo
    private java.lang.String ServicioAbo_address = "http://200.47.182.77:8080/wsTroubleshooting/services/ServicioAbo";

    public java.lang.String getServicioAboAddress() {
        return ServicioAbo_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioAboWSDDServiceName = "ServicioAbo";

    public java.lang.String getServicioAboWSDDServiceName() {
        return ServicioAboWSDDServiceName;
    }

    public void setServicioAboWSDDServiceName(java.lang.String name) {
        ServicioAboWSDDServiceName = name;
    }

    public net.cablen.soporte.ws.ServicioAbo getServicioAbo() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioAbo_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioAbo(endpoint);
    }

    public net.cablen.soporte.ws.ServicioAbo getServicioAbo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.cablen.soporte.ws.ServicioAboSoapBindingStub _stub = new net.cablen.soporte.ws.ServicioAboSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioAboWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioAboEndpointAddress(java.lang.String address) {
        ServicioAbo_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.cablen.soporte.ws.ServicioAbo.class.isAssignableFrom(serviceEndpointInterface)) {
                net.cablen.soporte.ws.ServicioAboSoapBindingStub _stub = new net.cablen.soporte.ws.ServicioAboSoapBindingStub(new java.net.URL(ServicioAbo_address), this);
                _stub.setPortName(getServicioAboWSDDServiceName());
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
        if ("ServicioAbo".equals(inputPortName)) {
            return getServicioAbo();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.soporte.cablen.net", "ServicioAboService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.soporte.cablen.net", "ServicioAbo"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioAbo".equals(portName)) {
            setServicioAboEndpointAddress(address);
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
