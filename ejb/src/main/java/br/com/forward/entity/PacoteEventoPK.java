 package br.com.forward.entity;
 
 import java.math.BigInteger;
 import javax.persistence.Column;
 import javax.persistence.Embeddable;
 
 @Embeddable
 public class PacoteEventoPK
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Column(name="fwdpctcod", insertable=false, updatable=false, unique=true, nullable=false)
   private int codigoPacote;
 
   @Column(name="fwdevtcod", insertable=false, updatable=false, unique=true, nullable=false)
   private BigInteger codigoEvento;
 
   public int getCodigoPacote()
   {
     return this.codigoPacote;
   }
   public void setCodigoPacote(int codigoPacote) {
     this.codigoPacote = codigoPacote;
   }
   public BigInteger getCodigoEvento() {
     return this.codigoEvento;
   }
   public void setCodigoEvento(BigInteger codigoEvento) {
     this.codigoEvento = codigoEvento;
   }
 
   public boolean equals(Object other) {
     if (this == other) {
       return true;
     }
     if (!(other instanceof PacoteEventoPK)) {
       return false;
     }
     PacoteEventoPK castOther = (PacoteEventoPK)other;
     return 
       (this.codigoPacote == castOther.codigoPacote) && 
       (this.codigoEvento.equals(castOther.codigoEvento));
   }
 
   public int hashCode() {
     int prime = 31;
     int hash = 17;
     hash = hash * 31 + this.codigoPacote;
     hash = hash * 31 + this.codigoEvento.hashCode();
 
     return hash;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.PacoteEventoPK
 * JD-Core Version:    0.6.0
 */