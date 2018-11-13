package com.ipartek.formacion.SpringFormularios;

public class Greeting {
		private long id;
	    private String content;
	    

	    public long getId() {
	    	  System.out.println("ID en el pojo:"+ id);
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getContent() {
	    	  System.out.println("content en el pojo:"+ content);
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	
}
