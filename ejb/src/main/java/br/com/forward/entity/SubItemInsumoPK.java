 package br.com.forward.entity;
 
 import java.io.Serializable;
 import javax.persistence.Column;
 import javax.persistence.Embeddable;
 
 @Embeddable
 public class SubItemInsumoPK
   implements Serializable
 {
   private static final long serialVersionUID = -3673490431085735991L;
 
   @Column(name="idfwdinspai")
   private Integer codigoInsumoPai;
 
   @Column(name="subfwdinsid")
   private Integer codigoSubInsumo;
 
   public Integer getCodigoInsumoPai()
   {
     return this.codigoInsumoPai;
   }
 
   public void setCodigoInsumoPai(Integer codigoInsumoPai) {
     this.codigoInsumoPai = codigoInsumoPai;
   }
 
   public Integer getCodigoSubInsumo() {
     return this.codigoSubInsumo;
   }
 
   public void setCodigoSubInsumo(Integer codigoSubInsumo) {
     this.codigoSubInsumo = codigoSubInsumo;
   }
 
   public int hashCode()
   {
     int prime = 31;
     int result = 1;
     result = 31 * result + (this.codigoInsumoPai == null ? 0 : this.codigoInsumoPai.hashCode());
     result = 31 * result + (this.codigoSubInsumo == null ? 0 : this.codigoSubInsumo.hashCode());
     return result;
   }
 
   public boolean equals(Object obj)
   {
     if (this == obj)
       return true;
     if (obj == null)
       return false;
     if (getClass() != obj.getClass())
       return false;
     SubItemInsumoPK other = (SubItemInsumoPK)obj;
     if (this.codigoInsumoPai == null) {
       if (other.codigoInsumoPai != null)
         return false;
     } else if (!this.codigoInsumoPai.equals(other.codigoInsumoPai))
       return false;
     if (this.codigoSubInsumo == null) {
       if (other.codigoSubInsumo != null)
         return false;
     } else if (!this.codigoSubInsumo.equals(other.codigoSubInsumo))
       return false;
     return true;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.SubItemInsumoPK
 * JD-Core Version:    0.6.0
 */