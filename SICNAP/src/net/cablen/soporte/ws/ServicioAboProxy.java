package net.cablen.soporte.ws;

public class ServicioAboProxy implements net.cablen.soporte.ws.ServicioAbo {
  private String _endpoint = null;
  private net.cablen.soporte.ws.ServicioAbo servicioAbo = null;
  
  public ServicioAboProxy() {
    _initServicioAboProxy();
  }
  
  public ServicioAboProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioAboProxy();
  }
  
  private void _initServicioAboProxy() {
    try {
      servicioAbo = (new net.cablen.soporte.ws.ServicioAboServiceLocator()).getServicioAbo();
      if (servicioAbo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioAbo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioAbo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioAbo != null)
      ((javax.xml.rpc.Stub)servicioAbo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.cablen.soporte.ws.ServicioAbo getServicioAbo() {
    if (servicioAbo == null)
      _initServicioAboProxy();
    return servicioAbo;
  }
  
  public net.cablen.soporte.ws.Abonado[] resultLista(java.lang.String ci) throws java.rmi.RemoteException{
    if (servicioAbo == null)
      _initServicioAboProxy();
    return servicioAbo.resultLista(ci);
  }
  
  
}