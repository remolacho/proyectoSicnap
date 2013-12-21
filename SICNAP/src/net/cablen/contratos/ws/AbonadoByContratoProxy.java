package net.cablen.contratos.ws;

public class AbonadoByContratoProxy implements net.cablen.contratos.ws.AbonadoByContrato {
  private String _endpoint = null;
  private net.cablen.contratos.ws.AbonadoByContrato abonadoByContrato = null;
  
  public AbonadoByContratoProxy() {
    _initAbonadoByContratoProxy();
  }
  
  public AbonadoByContratoProxy(String endpoint) {
    _endpoint = endpoint;
    _initAbonadoByContratoProxy();
  }
  
  private void _initAbonadoByContratoProxy() {
    try {
      abonadoByContrato = (new net.cablen.contratos.ws.AbonadoByContratoServiceLocator()).getAbonadoByContrato();
      if (abonadoByContrato != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)abonadoByContrato)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)abonadoByContrato)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (abonadoByContrato != null)
      ((javax.xml.rpc.Stub)abonadoByContrato)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.cablen.contratos.ws.AbonadoByContrato getAbonadoByContrato() {
    if (abonadoByContrato == null)
      _initAbonadoByContratoProxy();
    return abonadoByContrato;
  }
  
  public net.cablen.contratos.ws.Abonado resultContrato(java.lang.String contrato) throws java.rmi.RemoteException{
    if (abonadoByContrato == null)
      _initAbonadoByContratoProxy();
    return abonadoByContrato.resultContrato(contrato);
  }
  
  
}