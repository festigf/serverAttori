package com.app.util;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@NamedStoredProcedureQuery(
	    name = "getnrowsnpages", 
	    procedureName = "getnRowsnPages", 
	    resultClasses = { ClsnRownPages.class }, 
	    parameters = { 
	    		 @StoredProcedureParameter(name="tableName", type=String.class, mode=ParameterMode.IN), 
	    		 @StoredProcedureParameter(name="pageIndex", type=Integer.class, mode=ParameterMode.IN), 
	    		 @StoredProcedureParameter(name="pageSize", type=Integer.class, mode=ParameterMode.IN)
		})
@Table(name="clsnRownPages")
public class ClsnRownPages {
	@Id
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private int nRows;
	public int getnRows() {
		return nRows;
	}
	public void setnRows(int nRows) {
		this.nRows = nRows;
	}
	private int nPages;
	public int getnPages() {
		return nPages;
	}
	public void setnPages(int nPages) {
		this.nPages = nPages;
	}

}
