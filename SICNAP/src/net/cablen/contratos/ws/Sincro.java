/**
 * Sincro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.cablen.contratos.ws;

public class Sincro  implements java.io.Serializable {
    private java.lang.String cadena;

    private java.lang.String desError;

    private int error;

    public Sincro() {
    }

    public Sincro(
           java.lang.String cadena,
           java.lang.String desError,
           int error) {
           this.cadena = cadena;
           this.desError = desError;
           this.error = error;
    }


    /**
     * Gets the cadena value for this Sincro.
     * 
     * @return cadena
     */
    public java.lang.String getCadena() {
        return cadena;
    }


    /**
     * Sets the cadena value for this Sincro.
     * 
     * @param cadena
     */
    public void setCadena(java.lang.String cadena) {
        this.cadena = cadena;
    }


    /**
     * Gets the desError value for this Sincro.
     * 
     * @return desError
     */
    public java.lang.String getDesError() {
        return desError;
    }


    /**
     * Sets the desError value for this Sincro.
     * 
     * @param desError
     */
    public void setDesError(java.lang.String desError) {
        this.desError = desError;
    }


    /**
     * Gets the error value for this Sincro.
     * 
     * @return error
     */
    public int getError() {
        return error;
    }


    /**
     * Sets the error value for this Sincro.
     * 
     * @param error
     */
    public void setError(int error) {
        this.error = error;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sincro)) return false;
        Sincro other = (Sincro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cadena==null && other.getCadena()==null) || 
             (this.cadena!=null &&
              this.cadena.equals(other.getCadena()))) &&
            ((this.desError==null && other.getDesError()==null) || 
             (this.desError!=null &&
              this.desError.equals(other.getDesError()))) &&
            this.error == other.getError();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCadena() != null) {
            _hashCode += getCadena().hashCode();
        }
        if (getDesError() != null) {
            _hashCode += getDesError().hashCode();
        }
        _hashCode += getError();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sincro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "Sincro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cadena");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "cadena"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "desError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
