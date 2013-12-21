package net.cablen.contratos.ws;

public class SincronizarContratosProxy implements net.cablen.contratos.ws.SincronizarContratos {
  private String _endpoint = null;
  private net.cablen.contratos.ws.SincronizarContratos sincronizarContratos = null;
  
  public SincronizarContratosProxy() {
    _initSincronizarContratosProxy();
  }
  
  public SincronizarContratosProxy(String endpoint) {
    _endpoint = endpoint;
    _initSincronizarContratosProxy();
  }
  
  private void _initSincronizarContratosProxy() {
    try {
      sincronizarContratos = (new net.cablen.contratos.ws.SincronizarContratosServiceLocator()).getSincronizarContratos();
      if (sincronizarContratos != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sincronizarContratos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sincronizarContratos)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sincronizarContratos != null)
      ((javax.xml.rpc.Stub)sincronizarContratos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.cablen.contratos.ws.SincronizarContratos getSincronizarContratos() {
    if (sincronizarContratos == null)
      _initSincronizarContratosProxy();
    return sincronizarContratos;
  }
  
  public net.cablen.contratos.ws.Sincro resultContratos(java.lang.String boxy, java.lang.String strSql) throws java.rmi.RemoteException{
    if (sincronizarContratos == null)
      _initSincronizarContratosProxy();
    return sincronizarContratos.resultContratos(boxy, strSql);
  }
  
  
}