/**
 * Abonado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.cablen.contratos.ws;

public class Abonado  implements java.io.Serializable {
    private java.lang.String abonado;

    private java.lang.String apellido;

    private java.lang.String boxy;

    private java.lang.String contrato;

    private java.lang.String descError;

    private int error;

    private java.lang.String fechAlta;

    private java.lang.String nomCompleto;

    private java.lang.String nombre;

    private java.lang.String sector;

    public Abonado() {
    }

    public Abonado(
           java.lang.String abonado,
           java.lang.String apellido,
           java.lang.String boxy,
           java.lang.String contrato,
           java.lang.String descError,
           int error,
           java.lang.String fechAlta,
           java.lang.String nomCompleto,
           java.lang.String nombre,
           java.lang.String sector) {
           this.abonado = abonado;
           this.apellido = apellido;
           this.boxy = boxy;
           this.contrato = contrato;
           this.descError = descError;
           this.error = error;
           this.fechAlta = fechAlta;
           this.nomCompleto = nomCompleto;
           this.nombre = nombre;
           this.sector = sector;
    }


    /**
     * Gets the abonado value for this Abonado.
     * 
     * @return abonado
     */
    public java.lang.String getAbonado() {
        return abonado;
    }


    /**
     * Sets the abonado value for this Abonado.
     * 
     * @param abonado
     */
    public void setAbonado(java.lang.String abonado) {
        this.abonado = abonado;
    }


    /**
     * Gets the apellido value for this Abonado.
     * 
     * @return apellido
     */
    public java.lang.String getApellido() {
        return apellido;
    }


    /**
     * Sets the apellido value for this Abonado.
     * 
     * @param apellido
     */
    public void setApellido(java.lang.String apellido) {
        this.apellido = apellido;
    }


    /**
     * Gets the boxy value for this Abonado.
     * 
     * @return boxy
     */
    public java.lang.String getBoxy() {
        return boxy;
    }


    /**
     * Sets the boxy value for this Abonado.
     * 
     * @param boxy
     */
    public void setBoxy(java.lang.String boxy) {
        this.boxy = boxy;
    }


    /**
     * Gets the contrato value for this Abonado.
     * 
     * @return contrato
     */
    public java.lang.String getContrato() {
        return contrato;
    }


    /**
     * Sets the contrato value for this Abonado.
     * 
     * @param contrato
     */
    public void setContrato(java.lang.String contrato) {
        this.contrato = contrato;
    }


    /**
     * Gets the descError value for this Abonado.
     * 
     * @return descError
     */
    public java.lang.String getDescError() {
        return descError;
    }


    /**
     * Sets the descError value for this Abonado.
     * 
     * @param descError
     */
    public void setDescError(java.lang.String descError) {
        this.descError = descError;
    }


    /**
     * Gets the error value for this Abonado.
     * 
     * @return error
     */
    public int getError() {
        return error;
    }


    /**
     * Sets the error value for this Abonado.
     * 
     * @param error
     */
    public void setError(int error) {
        this.error = error;
    }


    /**
     * Gets the fechAlta value for this Abonado.
     * 
     * @return fechAlta
     */
    public java.lang.String getFechAlta() {
        return fechAlta;
    }


    /**
     * Sets the fechAlta value for this Abonado.
     * 
     * @param fechAlta
     */
    public void setFechAlta(java.lang.String fechAlta) {
        this.fechAlta = fechAlta;
    }


    /**
     * Gets the nomCompleto value for this Abonado.
     * 
     * @return nomCompleto
     */
    public java.lang.String getNomCompleto() {
        return nomCompleto;
    }


    /**
     * Sets the nomCompleto value for this Abonado.
     * 
     * @param nomCompleto
     */
    public void setNomCompleto(java.lang.String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }


    /**
     * Gets the nombre value for this Abonado.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Abonado.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the sector value for this Abonado.
     * 
     * @return sector
     */
    public java.lang.String getSector() {
        return sector;
    }


    /**
     * Sets the sector value for this Abonado.
     * 
     * @param sector
     */
    public void setSector(java.lang.String sector) {
        this.sector = sector;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Abonado)) return false;
        Abonado other = (Abonado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.abonado==null && other.getAbonado()==null) || 
             (this.abonado!=null &&
              this.abonado.equals(other.getAbonado()))) &&
            ((this.apellido==null && other.getApellido()==null) || 
             (this.apellido!=null &&
              this.apellido.equals(other.getApellido()))) &&
            ((this.boxy==null && other.getBoxy()==null) || 
             (this.boxy!=null &&
              this.boxy.equals(other.getBoxy()))) &&
            ((this.contrato==null && other.getContrato()==null) || 
             (this.contrato!=null &&
              this.contrato.equals(other.getContrato()))) &&
            ((this.descError==null && other.getDescError()==null) || 
             (this.descError!=null &&
              this.descError.equals(other.getDescError()))) &&
            this.error == other.getError() &&
            ((this.fechAlta==null && other.getFechAlta()==null) || 
             (this.fechAlta!=null &&
              this.fechAlta.equals(other.getFechAlta()))) &&
            ((this.nomCompleto==null && other.getNomCompleto()==null) || 
             (this.nomCompleto!=null &&
              this.nomCompleto.equals(other.getNomCompleto()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.sector==null && other.getSector()==null) || 
             (this.sector!=null &&
              this.sector.equals(other.getSector())));
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
        if (getAbonado() != null) {
            _hashCode += getAbonado().hashCode();
        }
        if (getApellido() != null) {
            _hashCode += getApellido().hashCode();
        }
        if (getBoxy() != null) {
            _hashCode += getBoxy().hashCode();
        }
        if (getContrato() != null) {
            _hashCode += getContrato().hashCode();
        }
        if (getDescError() != null) {
            _hashCode += getDescError().hashCode();
        }
        _hashCode += getError();
        if (getFechAlta() != null) {
            _hashCode += getFechAlta().hashCode();
        }
        if (getNomCompleto() != null) {
            _hashCode += getNomCompleto().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getSector() != null) {
            _hashCode += getSector().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Abonado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "Abonado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abonado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "abonado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "apellido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boxy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "boxy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contrato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "contrato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "descError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechAlta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "fechAlta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomCompleto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "nomCompleto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sector");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.contratos.cablen.net", "sector"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
