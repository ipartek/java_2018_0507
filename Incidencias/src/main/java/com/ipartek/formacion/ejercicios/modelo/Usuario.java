package com.ipartek.formacion.ejercicios.modelo;

import javax.validation.constraints.NotNull;

public class Usuario {
		
		@NotNull
		private Long id;

		private String email;
		private String pasword;
		
		
		
		public Usuario(Long id, String email, String pasword) {
			super();
			this.id = id;
			this.email = email;
			this.pasword = pasword;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPasword() {
			return pasword;
		}
		public void setPasword(String pasword) {
			this.pasword = pasword;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((pasword == null) ? 0 : pasword.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Usuario other = (Usuario) obj;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (pasword == null) {
				if (other.pasword != null)
					return false;
			} else if (!pasword.equals(other.pasword))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Usuario [id=" + id + ", email=" + email + ", pasword=" + pasword + "]";
		}
		
		

}
