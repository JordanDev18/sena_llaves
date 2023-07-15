/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sena.model.entity;

import com.example.sena.model.enums.Estado;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author LENOVO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="prestamo")
public class Prestamo {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "llave_id")
    private LlavesPrestramo llave;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Usuario instructor;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Usuario funcionario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraPrestamo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraDevolucion;

    private Estado estado;

    // Otros campos y métodos necesarios...

        public void marcarComoDevuelto() {
        // Verificar que el préstamo esté en estado prestado antes de marcarlo como devuelto.
        if (estado == Estado.PRESTADO) {
            // Actualizar la fecha y hora de devolución.
            fechaHoraDevolucion = new Date();

            // Registrar el préstamo en la tabla histórica.
            Historico registroHistorico = new Historico();
            registroHistorico.setLlave(llave);
            registroHistorico.setInstructor(instructor);
            registroHistorico.setFuncionario(funcionario);
            registroHistorico.setFechaHoraPrestamo(fechaHoraPrestamo);
            registroHistorico.setFechaHoraDevolucion(fechaHoraDevolucion);
            // (código para guardar el registroHistorico en la tabla histórica)

            // Eliminar el préstamo de la tabla de préstamos.
            // (código para eliminar el registro de la tabla de préstamos)

            // Cambiar el estado del préstamo a "Disponible".
            estado = Estado.DISPONIBLE;
        } else {
            // El préstamo ya ha sido devuelto o no estaba en estado prestado.
            // (manejar la situación apropiadamente)
        }
    }
}
