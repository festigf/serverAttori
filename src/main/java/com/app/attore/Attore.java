package com.app.attore;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Query;
//import org.eclipse.persistence.queries.StoredProcedureCall;
//import org.eclipse.persistence.queries.ReadAllQuery;
@Entity
@Table(name="attori")
@NamedStoredProcedureQuery(
    name = "getDataRows", 
    procedureName = "getDataRows", 
    resultClasses = { Attore.class }, 
    parameters = { 
    		 @StoredProcedureParameter(name="tableName", type=String.class, mode=ParameterMode.IN), 
    		 @StoredProcedureParameter(name="pageIndex", type=Integer.class, mode=ParameterMode.IN), 
    		 @StoredProcedureParameter(name="pageSize", type=Integer.class, mode=ParameterMode.IN)
	})

	  
public class Attore { 
	@Id     
    private Long codAttore;
    public Long getCodAttore() {
		return codAttore;
	}
	public void setCodAttore(Long codAttore) {
		this.codAttore = codAttore;
	}
	private String nome;
    private Long annoNascita;
    private String nazionalita;
    public Attore(){}
    public Attore(  Long codAttore,
                    String nome,
                    Long annoNascita,
                    String nazionalita){
        this.codAttore=codAttore;
        this.nome=nome;
        this.annoNascita=annoNascita;
        this.nazionalita=nazionalita;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
         this.nome=nome;
    }
    public Long getAnnoNascita(){
        return this.annoNascita;
    }
    public void setAnnoNascita(Long annoNascita){
        this.annoNascita=annoNascita;
    }
    public String getNazionalita(){
        return this.nazionalita;
    }
    public void setNazionalita(String nazionalita){
        this.nazionalita=nazionalita;
    }
    @Override
    public String toString() {
      return "{codAttore:" + codAttore + ", nome:" + nome + ", annoNascita:" + annoNascita + ", nazionalita=" + nazionalita +"}";
    }
}