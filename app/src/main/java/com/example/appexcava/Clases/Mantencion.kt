package com.example.appexcava.Clases
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Mantenciones")
class Mantencion(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "nombre_trabajador")
    private var nombreTrabajador: String = "",
    @ColumnInfo(name = "fecha")
    var fecha: String = "",
    @ColumnInfo(name = "faena")
    var faena: String = "",
    @ColumnInfo(name = "mantencion_de")
    var mantencionDe: Int = 0,
    @ColumnInfo(name = "horometro_mantencion")
    var horometroMantencion: Int = 0,
    @ColumnInfo(name = "horometro_prox_mantencion")
    var horometroProxMantencion: Int = 0,
    //Esto podría ser una lista de Boolean?
    @ColumnInfo(name = "engrase")
    var engrase: Boolean? = null,
    @ColumnInfo(name = "aceite_motor")
    var aceiteMotor: Boolean? = null,
    @ColumnInfo(name = "aceite_transmision")
    var aceiteTransmision: Boolean? = null,
    @ColumnInfo(name = "aceite_diferencial")
    var aceiteDiferencial: Boolean? = null,
    @ColumnInfo(name = "aceite_sistema_hidraulico")
    var aceiteSistemaHidraulico: Boolean? = null,
    @ColumnInfo(name = "aceite_sistema_frenos")
    var aceiteSistemaFrenos: Boolean? = null,
    @ColumnInfo(name = "filtros_aceite_motor")
    var filtrosAceitesMotor: Boolean? = null,
    @ColumnInfo(name = "filtros_combustible")
    var filtrosCombustible: Boolean? = null,
    @ColumnInfo(name = "filtros_aceite_transmision")
    var filtrosAceiteTransmision: Boolean? = null,
    @ColumnInfo(name = "filtros_aire_interior")
    var filtrosAireInterior: Boolean? = null,
    @ColumnInfo(name = "filtros_aire_exterior")
    var filtrosAireExterior: Boolean? = null,
    @ColumnInfo(name = "filtros_aceite_hidraulico")
    var filtrosAceiteHidraulico: Boolean? = null,
    @ColumnInfo(name = "filtros_decantador_agua")
    var filtrosDecantadorAgua: Boolean? = null,
    @ColumnInfo(name = "limpieza_filtro_cabina")
    var limpiezaFiltroCabina: Boolean? = null,
    @ColumnInfo(name = "observaciones")
    var observaciones: String = "",
    var maquinaId: Int = 0,
    var empresaId: Int = 0
) {

    fun getNombreTrabajador(): String {
        return nombreTrabajador
    }

    fun setNombreTrabajador(nuevoNombreTrabajador: String) {
        nombreTrabajador = nuevoNombreTrabajador

    }

}