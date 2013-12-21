package net.cablen.precintos.ws;

public class SincronizarPrecintosProxy implements net.cablen.precintos.ws.SincronizarPrecintos {
  private String _endpoint = null;
  private net.cablen.precintos.ws.SincronizarPrecintos sincronizarPrecintos = null;
  
  public SincronizarPrecintosProxy() {
    _initSincronizarPrecintosProxy();
  }
  
  public SincronizarPrecintosProxy(String endpoint) {
    _endpoint = endpoint;
    _initSincronizarPrecintosProxy();
  }
  
  private void _initSincronizarPrecintosProxy() {
    try {
      sincronizarPrecintos = (new net.cablen.precintos.ws.SincronizarPrecintosServiceLocator()).getSincronizarPrecintos();
      if (sincronizarPrecintos != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sincronizarPrecintos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sincronizarPrecintos)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sincronizarPrecintos != null)
      ((javax.xml.rpc.Stub)sincronizarPrecintos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.cablen.precintos.ws.SincronizarPrecintos getSincronizarPrecintos() {
    if (sincronizarPrecintos == null)
      _initSincronizarPrecintosProxy();
    return sincronizarPrecintos;
  }
  
  public net.cablen.precintos.ws.Sincro resultPrecintos(java.lang.String boxy, java.lang.String strSql) throws java.rmi.RemoteException{
    if (sincronizarPrecintos == null)
      _initSincronizarPrecintosProxy();
    return sincronizarPrecintos.resultPrecintos(boxy, strSql);
  }
  
  
}