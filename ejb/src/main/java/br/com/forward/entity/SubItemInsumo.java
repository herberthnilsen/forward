 package br.com.forward.entity;
 
 import javax.persistence.EmbeddedId;
 import javax.persistence.Entity;
 import javax.persistence.ManyToOne;
 import javax.persistence.Table;
 
 @Entity
 @Table(name="fwdsubins")
 public class SubItemInsumo
 {
 
   @EmbeddedId
   private SubItemInsumoPK subItemPK;
 
   @ManyToOne
   private Insumo insumo;
 
   public SubItemInsumoPK getSubItemPK()
   {
     return this.subItemPK;
   }
 
   public void setSubItemPK(SubItemInsumoPK subItemPK) {
     this.subItemPK = subItemPK;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.SubItemInsumo
 * JD-Core Version:    0.6.0
 */