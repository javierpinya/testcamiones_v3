package com.javierpinya.testcamiones_v3.Clases;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.javierpinya.testcamiones_v3.Constants.Constants;
import com.javierpinya.testcamiones_v3.Converters.Converters;

import java.util.Date;

@Entity(tableName = Constants.NAME_TABLE_INSPECCION,
        indices = {@Index(value = {"id"}, unique = true)}
)
@TypeConverters(Converters.class)
public class InspeccionEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String inspeccion;
    public String inspector;
    public String instalacion;
    public String cisterna;
    public Date fechaInicioInspeccion;
    public String albaran;
    public String conductor;
    public String transportista;
    public String empresaTablaCalibracion;
    public String tipoComponente;
    public String observaciones;
    public Date fechaFinInspeccion;
    public boolean isPermisoConducir=true;
    public boolean isAdrConductor=true;
    public boolean isItvTractora=true;
    public boolean isAdrTractora=true;
    public boolean isItvCisterna=true;
    public boolean isAdrCisterna=true;
    public boolean isFichaSeguridad=true;
    public Date fechaTablaCalibracion;
    public boolean isTChip=true;
    public boolean isCChip=true;
    public boolean isSuperficieAntideslizante=true;
    public boolean isCInspeccionada=false;
    public String tractora;
    public boolean isPosicionamientoAdecuadoEnIsleta=true;
    public boolean isAccFrenoEstacionamientoMarchaCorta=true;
    public boolean isAccDesBaterias=true;
    public boolean isApagallamas=true;
    public boolean isDescTfnoMovil=true;
    public boolean isInterruptorEmergenciaYFuego=true;
    public boolean isConexionTomaTierra=true;
    public boolean isConexionMangueraGases=true;
    public boolean isPurgaCompartimentos=true;
    public boolean isRopaSeguridad=true;
    public boolean isEstanqueidadCisterna=true;
    public boolean isEstanqueidadValvulasApi=true;
    public boolean isEstanqueidadCajon=true;
    public boolean isRecogerAlbaran=true;
    public boolean isTC2=true;
    public boolean isMontajeCorrectoTags=true;
    public boolean isBajadaTagPlanta=true;
    public boolean isLecturaTagIsleta=true;
    public boolean isTInspeccionada=false;
    public boolean isTFavorable=false;
    public boolean isTRevisada=false;
    public boolean isTBloqueada=false;
    public boolean isCFavorable=false;
    public boolean isCRevisada=false;
    public boolean isCBloqueada=false;

    public InspeccionEntity(String inspeccion, String inspector, String instalacion, String cisterna, Date fechaInicioInspeccion, String albaran, String conductor, String transportista, String empresaTablaCalibracion, String tipoComponente, String observaciones, Date fechaFinInspeccion, boolean isPermisoConducir, boolean isAdrConductor, boolean isItvTractora, boolean isAdrTractora, boolean isItvCisterna, boolean isAdrCisterna, boolean isFichaSeguridad, Date fechaTablaCalibracion, boolean isTChip, boolean isCChip, boolean isSuperficieAntideslizante, boolean isCInspeccionada, String tractora, boolean isPosicionamientoAdecuadoEnIsleta, boolean isAccFrenoEstacionamientoMarchaCorta, boolean isAccDesBaterias, boolean isApagallamas, boolean isDescTfnoMovil, boolean isInterruptorEmergenciaYFuego, boolean isConexionTomaTierra, boolean isConexionMangueraGases, boolean isPurgaCompartimentos, boolean isRopaSeguridad, boolean isEstanqueidadCisterna, boolean isEstanqueidadValvulasApi, boolean isEstanqueidadCajon, boolean isRecogerAlbaran, boolean isTC2, boolean isMontajeCorrectoTags, boolean isBajadaTagPlanta, boolean isLecturaTagIsleta, boolean isTInspeccionada, boolean isTFavorable, boolean isTRevisada, boolean isTBloqueada, boolean isCFavorable, boolean isCRevisada, boolean isCBloqueada) {
        this.inspeccion = inspeccion;
        this.inspector = inspector;
        this.instalacion = instalacion;
        this.cisterna = cisterna;
        this.fechaInicioInspeccion = new Date();
        this.fechaInicioInspeccion = fechaInicioInspeccion;
        this.albaran = albaran;
        this.conductor = conductor;
        this.transportista = transportista;
        this.empresaTablaCalibracion = empresaTablaCalibracion;
        this.tipoComponente = tipoComponente;
        this.observaciones = observaciones;
        this.fechaFinInspeccion = new Date();
        this.fechaFinInspeccion = fechaFinInspeccion;
        this.isPermisoConducir = isPermisoConducir;
        this.isAdrConductor = isAdrConductor;
        this.isItvTractora = isItvTractora;
        this.isAdrTractora = isAdrTractora;
        this.isItvCisterna = isItvCisterna;
        this.isAdrCisterna = isAdrCisterna;
        this.isFichaSeguridad = isFichaSeguridad;
        this.fechaTablaCalibracion = new Date();
        this.fechaTablaCalibracion = fechaTablaCalibracion;
        this.isTChip = isTChip;
        this.isCChip = isCChip;
        this.isSuperficieAntideslizante = isSuperficieAntideslizante;
        this.isCInspeccionada = isCInspeccionada;
        this.tractora = tractora;
        this.isPosicionamientoAdecuadoEnIsleta = isPosicionamientoAdecuadoEnIsleta;
        this.isAccFrenoEstacionamientoMarchaCorta = isAccFrenoEstacionamientoMarchaCorta;
        this.isAccDesBaterias = isAccDesBaterias;
        this.isApagallamas = isApagallamas;
        this.isDescTfnoMovil = isDescTfnoMovil;
        this.isInterruptorEmergenciaYFuego = isInterruptorEmergenciaYFuego;
        this.isConexionTomaTierra = isConexionTomaTierra;
        this.isConexionMangueraGases = isConexionMangueraGases;
        this.isPurgaCompartimentos = isPurgaCompartimentos;
        this.isRopaSeguridad = isRopaSeguridad;
        this.isEstanqueidadCisterna = isEstanqueidadCisterna;
        this.isEstanqueidadValvulasApi = isEstanqueidadValvulasApi;
        this.isEstanqueidadCajon = isEstanqueidadCajon;
        this.isRecogerAlbaran = isRecogerAlbaran;
        this.isTC2 = isTC2;
        this.isMontajeCorrectoTags = isMontajeCorrectoTags;
        this.isBajadaTagPlanta = isBajadaTagPlanta;
        this.isLecturaTagIsleta = isLecturaTagIsleta;
        this.isTInspeccionada = isTInspeccionada;
        this.isTFavorable = isTFavorable;
        this.isTRevisada = isTRevisada;
        this.isTBloqueada = isTBloqueada;
        this.isCFavorable = isCFavorable;
        this.isCRevisada = isCRevisada;
        this.isCBloqueada = isCBloqueada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCisterna() {
        return cisterna;
    }

    public void setCisterna(String cisterna) {
        this.cisterna = cisterna;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getTransportista() {
        return transportista;
    }

    public void setTransportista(String transportista) {
        this.transportista = transportista;
    }

    public String getTractora() {
        return tractora;
    }

    public void setTractora(String tractora) {
        this.tractora = tractora;
    }

    public String getInspeccion() {
        return inspeccion;
    }

    public void setInspeccion(String inspeccion) {
        this.inspeccion = inspeccion;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(String instalacion) {
        this.instalacion = instalacion;
    }

    public Date getFechaInicioInspeccion() {
        return fechaInicioInspeccion;
    }

    public void setFechaInicioInspeccion(Date fechaInicioInspeccion) {
        this.fechaInicioInspeccion = fechaInicioInspeccion;
    }

    public String getAlbaran() {
        return albaran;
    }

    public void setAlbaran(String albaran) {
        this.albaran = albaran;
    }

    public String getEmpresaTablaCalibracion() {
        return empresaTablaCalibracion;
    }

    public void setEmpresaTablaCalibracion(String empresaTablaCalibracion) {
        this.empresaTablaCalibracion = empresaTablaCalibracion;
    }

    public String getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(String tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaFinInspeccion() {
        return fechaFinInspeccion;
    }

    public void setFechaFinInspeccion(Date fechaFinInspeccion) {
        this.fechaFinInspeccion = fechaFinInspeccion;
    }

    public boolean isPermisoConducir() {
        return isPermisoConducir;
    }

    public void setPermisoConducir(boolean permisoConducir) {
        isPermisoConducir = permisoConducir;
    }

    public boolean isAdrConductor() {
        return isAdrConductor;
    }

    public void setAdrConductor(boolean adrConductor) {
        isAdrConductor = adrConductor;
    }

    public boolean isItvTractora() {
        return isItvTractora;
    }

    public void setItvTractora(boolean itvTractora) {
        isItvTractora = itvTractora;
    }

    public boolean isAdrTractora() {
        return isAdrTractora;
    }

    public void setAdrTractora(boolean adrTractora) {
        isAdrTractora = adrTractora;
    }

    public boolean isItvCisterna() {
        return isItvCisterna;
    }

    public void setItvCisterna(boolean itvCisterna) {
        isItvCisterna = itvCisterna;
    }

    public boolean isAdrCisterna() {
        return isAdrCisterna;
    }

    public void setAdrCisterna(boolean adrCisterna) {
        isAdrCisterna = adrCisterna;
    }

    public boolean isFichaSeguridad() {
        return isFichaSeguridad;
    }

    public void setFichaSeguridad(boolean fichaSeguridad) {
        isFichaSeguridad = fichaSeguridad;
    }

    public Date getFechaTablaCalibracion() {
        return fechaTablaCalibracion;
    }

    public void setFechaTablaCalibracion(Date fechaTablaCalibracion) {
        this.fechaTablaCalibracion = fechaTablaCalibracion;
    }

    public boolean isTChip() {
        return isTChip;
    }

    public void setTChip(boolean TChip) {
        isTChip = TChip;
    }

    public boolean isCChip() {
        return isCChip;
    }

    public void setCChip(boolean CChip) {
        isCChip = CChip;
    }

    public boolean isSuperficieAntideslizante() {
        return isSuperficieAntideslizante;
    }

    public void setSuperficieAntideslizante(boolean superficieAntideslizante) {
        isSuperficieAntideslizante = superficieAntideslizante;
    }

    public boolean isCInspeccionada() {
        return isCInspeccionada;
    }

    public void setCInspeccionada(boolean CInspeccionada) {
        isCInspeccionada = CInspeccionada;
    }

    public boolean isPosicionamientoAdecuadoEnIsleta() {
        return isPosicionamientoAdecuadoEnIsleta;
    }

    public void setPosicionamientoAdecuadoEnIsleta(boolean posicionamientoAdecuadoEnIsleta) {
        isPosicionamientoAdecuadoEnIsleta = posicionamientoAdecuadoEnIsleta;
    }

    public boolean isAccFrenoEstacionamientoMarchaCorta() {
        return isAccFrenoEstacionamientoMarchaCorta;
    }

    public void setAccFrenoEstacionamientoMarchaCorta(boolean accFrenoEstacionamientoMarchaCorta) {
        isAccFrenoEstacionamientoMarchaCorta = accFrenoEstacionamientoMarchaCorta;
    }

    public boolean isAccDesBaterias() {
        return isAccDesBaterias;
    }

    public void setAccDesBaterias(boolean accDesBaterias) {
        isAccDesBaterias = accDesBaterias;
    }

    public boolean isApagallamas() {
        return isApagallamas;
    }

    public void setApagallamas(boolean apagallamas) {
        isApagallamas = apagallamas;
    }

    public boolean isDescTfnoMovil() {
        return isDescTfnoMovil;
    }

    public void setDescTfnoMovil(boolean descTfnoMovil) {
        isDescTfnoMovil = descTfnoMovil;
    }

    public boolean isInterruptorEmergenciaYFuego() {
        return isInterruptorEmergenciaYFuego;
    }

    public void setInterruptorEmergenciaYFuego(boolean interruptorEmergenciaYFuego) {
        isInterruptorEmergenciaYFuego = interruptorEmergenciaYFuego;
    }

    public boolean isConexionTomaTierra() {
        return isConexionTomaTierra;
    }

    public void setConexionTomaTierra(boolean conexionTomaTierra) {
        isConexionTomaTierra = conexionTomaTierra;
    }

    public boolean isConexionMangueraGases() {
        return isConexionMangueraGases;
    }

    public void setConexionMangueraGases(boolean conexionMangueraGases) {
        isConexionMangueraGases = conexionMangueraGases;
    }

    public boolean isPurgaCompartimentos() {
        return isPurgaCompartimentos;
    }

    public void setPurgaCompartimentos(boolean purgaCompartimentos) {
        isPurgaCompartimentos = purgaCompartimentos;
    }

    public boolean isRopaSeguridad() {
        return isRopaSeguridad;
    }

    public void setRopaSeguridad(boolean ropaSeguridad) {
        isRopaSeguridad = ropaSeguridad;
    }

    public boolean isEstanqueidadCisterna() {
        return isEstanqueidadCisterna;
    }

    public void setEstanqueidadCisterna(boolean estanqueidadCisterna) {
        isEstanqueidadCisterna = estanqueidadCisterna;
    }

    public boolean isEstanqueidadValvulasApi() {
        return isEstanqueidadValvulasApi;
    }

    public void setEstanqueidadValvulasApi(boolean estanqueidadValvulasApi) {
        isEstanqueidadValvulasApi = estanqueidadValvulasApi;
    }

    public boolean isEstanqueidadCajon() {
        return isEstanqueidadCajon;
    }

    public void setEstanqueidadCajon(boolean estanqueidadCajon) {
        isEstanqueidadCajon = estanqueidadCajon;
    }

    public boolean isRecogerAlbaran() {
        return isRecogerAlbaran;
    }

    public void setRecogerAlbaran(boolean recogerAlbaran) {
        isRecogerAlbaran = recogerAlbaran;
    }

    public boolean isTC2() {
        return isTC2;
    }

    public void setTC2(boolean TC2) {
        isTC2 = TC2;
    }

    public boolean isMontajeCorrectoTags() {
        return isMontajeCorrectoTags;
    }

    public void setMontajeCorrectoTags(boolean montajeCorrectoTags) {
        isMontajeCorrectoTags = montajeCorrectoTags;
    }

    public boolean isBajadaTagPlanta() {
        return isBajadaTagPlanta;
    }

    public void setBajadaTagPlanta(boolean bajadaTagPlanta) {
        isBajadaTagPlanta = bajadaTagPlanta;
    }

    public boolean isLecturaTagIsleta() {
        return isLecturaTagIsleta;
    }

    public void setLecturaTagIsleta(boolean lecturaTagIsleta) {
        isLecturaTagIsleta = lecturaTagIsleta;
    }

    public boolean isTInspeccionada() {
        return isTInspeccionada;
    }

    public void setTInspeccionada(boolean TInspeccionada) {
        isTInspeccionada = TInspeccionada;
    }

    public boolean isTFavorable() {
        return isTFavorable;
    }

    public void setTFavorable(boolean TFavorable) {
        isTFavorable = TFavorable;
    }

    public boolean isTRevisada() {
        return isTRevisada;
    }

    public void setTRevisada(boolean TRevisada) {
        isTRevisada = TRevisada;
    }

    public boolean isTBloqueada() {
        return isTBloqueada;
    }

    public void setTBloqueada(boolean TBloqueada) {
        isTBloqueada = TBloqueada;
    }

    public boolean isCFavorable() {
        return isCFavorable;
    }

    public void setCFavorable(boolean CFavorable) {
        isCFavorable = CFavorable;
    }

    public boolean isCRevisada() {
        return isCRevisada;
    }

    public void setCRevisada(boolean CRevisada) {
        isCRevisada = CRevisada;
    }

    public boolean isCBloqueada() {
        return isCBloqueada;
    }

    public void setCBloqueada(boolean CBloqueada) {
        isCBloqueada = CBloqueada;
    }
}
