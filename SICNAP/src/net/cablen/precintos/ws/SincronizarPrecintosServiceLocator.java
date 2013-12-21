/**
 * SincronizarPrecintosServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.cablen.precintos.ws;

public class SincronizarPrecintosServiceLocator extends org.apache.axis.client.Service implements net.cablen.precintos.ws.SincronizarPrecintosService {

    public SincronizarPrecintosServiceLocator() {
    }


    public SincronizarPrecintosServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SincronizarPrecintosServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SincronizarPrecintos
    private java.lang.String SincronizarPrecintos_address = "http://200.47.182.77:8080/wsPrecintos/services/SincronizarPrecintos";

    public java.lang.String getSincronizarPrecintosAddress() {
        return SincronizarPrecintos_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SincronizarPrecintosWSDDServiceName = "SincronizarPrecintos";

    public java.lang.String getSincronizarPrecintosWSDDServiceName() {
        return SincronizarPrecintosWSDDServiceName;
    }

    public void setSincronizarPrecintosWSDDServiceName(java.lang.String name) {
        SincronizarPrecintosWSDDServiceName = name;
    }

    public net.cablen.precintos.ws.SincronizarPrecintos getSincronizarPrecintos() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SincronizarPrecintos_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSincronizarPrecintos(endpoint);
    }

    public net.cablen.precintos.ws.SincronizarPrecintos getSincronizarPrecintos(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.cablen.precintos.ws.SincronizarPrecintosSoapBindingStub _stub = new net.cablen.precintos.ws.SincronizarPrecintosSoapBindingStub(portAddress, this);
            _stub.setPortName(getSincronizarPrecintosWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSincronizarPrecintosEndpointAddress(java.lang.String address) {
        SincronizarPrecintos_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.cablen.precintos.ws.SincronizarPrecintos.class.isAssignableFrom(serviceEndpointInterface)) {
                net.cablen.precintos.ws.SincronizarPrecintosSoapBindingStub _stub = new net.cablen.precintos.ws.SincronizarPrecintosSoapBindingStub(new java.net.URL(SincronizarPrecintos_address), this);
                _stub.setPortName(getSincronizarPrecintosWSDDServiceName());
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
        if ("SincronizarPrecintos".equals(inputPortName)) {
            return getSincronizarPrecintos();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.precintos.cablen.net", "SincronizarPrecintosService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.precintos.cablen.net", "SincronizarPrecintos"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SincronizarPrecintos".equals(portName)) {
            setSincronizarPrecintosEndpointAddress(address);
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
