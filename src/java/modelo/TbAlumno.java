/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author u05521
 */
@Entity
@Table(name = "tb_alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAlumno.findAll", query = "SELECT t FROM TbAlumno t"),
    @NamedQuery(name = "TbAlumno.findByCodAlumno", query = "SELECT t FROM TbAlumno t WHERE t.codAlumno = :codAlumno"),
    @NamedQuery(name = "TbAlumno.findByApellidos", query = "SELECT t FROM TbAlumno t WHERE t.apellidos = :apellidos"),
    @NamedQuery(name = "TbAlumno.findByNombres", query = "SELECT t FROM TbAlumno t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "TbAlumno.findByFecNacimiento", query = "SELECT t FROM TbAlumno t WHERE t.fecNacimiento = :fecNacimiento")})
public class TbAlumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_alumno")
    private String codAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fecNacimiento;

    public TbAlumno() {
    }

    public TbAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    public TbAlumno(String codAlumno, String apellidos, String nombres, Date fecNacimiento) {
        this.codAlumno = codAlumno;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fecNacimiento = fecNacimiento;
    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAlumno != null ? codAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAlumno)) {
            return false;
        }
        TbAlumno other = (TbAlumno) object;
        if ((this.codAlumno == null && other.codAlumno != null) || (this.codAlumno != null && !this.codAlumno.equals(other.codAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbAlumno[ codAlumno=" + codAlumno + " ]";
    }
    
}
