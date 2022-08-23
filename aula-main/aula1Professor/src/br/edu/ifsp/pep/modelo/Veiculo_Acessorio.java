/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity //Define que esta classe é uma entidade
@Table(name = "veiculo_acessorio", uniqueConstraints = {

    @UniqueConstraint(name = "UniqueCodigos", 
        columnNames = {"codigoVeiculo", "codigoAcessorio"}),//nomes das colunas no banco de dados      
        
})
public class Veiculo_Acessorio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoVeiculo")
    private Integer codigoVeiculo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoAcessorio")
    private Integer codigoAcessorio;

    public Integer getCodigoVeiculo() {
        return codigoVeiculo;
    }

    public Integer getCodigoAcessorio() {
        return codigoAcessorio;
    }
    
}
