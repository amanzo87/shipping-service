package it.interno.shipping.entity;

import it.interno.shipping.entity.key.ShippingKey;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(schema = "SHOP1", name = "SHIPPING")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@IdClass(ShippingKey.class)
public class Shipping implements Cloneable {

    @Id
    @Column(name = "ID_SHIPPING", columnDefinition = "INTEGER", nullable = false)
    Integer idSpedizione ;

    @Id
    @Column(name = "TS_INSERIMENTO", columnDefinition = "TIMESTAMP", scale = 6, nullable = false)
    Timestamp tsInserimento;

    @Column(name = "TRACKING_NUMBER", columnDefinition = "VARCHAR2", length = 100)
    String trackingNumber;

    @Column(name = "SHIPPING_METHOD", columnDefinition = "INTEGER")
    Integer tipologiaSpedizione;

    @Column(name = "SHIPPING_DATE", columnDefinition = "DATE")
    LocalDate dataSpedizione;

    @Column(name = "ESTIMATED_DELIVERY_DATE", columnDefinition = "DATE")
    LocalDate dataConsegnaStimata;

    @Column(name = "ACTUAL_DELIVERY_DATE", columnDefinition = "DATE")
    LocalDate dataConsegnaEffettiva;

    @Column(name = "SHIPPING_STATUS", columnDefinition = "INTEGER")
    Integer statoSpedizione;

    @Column(name = "SHIPPING_ADDRESS", columnDefinition = "VARCHAR2", length = 100)
    String indirizzoSpedizione;

    @Column(name = "SHIPPING_NOTE", columnDefinition = "VARCHAR2", length = 100)
    String noteSpedizione;

    @Column(name = "ID_CUSTOMER", columnDefinition = "INTEGER")
    Integer idCliente;

    @Column(name = "ID_UTE_INS", columnDefinition = "CHAR", length = 8, nullable = false)
    String idUtenteInserimento;

    @Column(name = "TS_CANCELLAZIONE", columnDefinition = "TIMESTAMP", scale = 6)
    Timestamp tsCancellazione;

    @Column(name = "ID_UTE_CAN", columnDefinition = "CHAR", length = 8)
    String idUtenteCancellazione;

    @Column(name = "ID_ORDER", columnDefinition = "INTEGER")
    Integer idOrdine ;

    @Column(name = "TS_INSERIMENTO_ORDER", columnDefinition = "TIMESTAMP", scale = 6)
    Timestamp tsInserimentoOrdine;

    public Integer getIdSpedizione() {
        return idSpedizione;
    }

    public void setIdSpedizione(Integer idSpedizione) {
        this.idSpedizione = idSpedizione;
    }

    public Timestamp getTsInserimento() {
        return tsInserimento;
    }

    public void setTsInserimento(Timestamp tsInserimento) {
        this.tsInserimento = tsInserimento;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Integer getTipologiaSpedizione() {
        return tipologiaSpedizione;
    }

    public void setTipologiaSpedizione(Integer tipologiaSpedizione) {
        this.tipologiaSpedizione = tipologiaSpedizione;
    }

    public LocalDate getDataSpedizione() {
        return dataSpedizione;
    }

    public void setDataSpedizione(LocalDate dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }

    public LocalDate getDataConsegnaStimata() {
        return dataConsegnaStimata;
    }

    public void setDataConsegnaStimata(LocalDate dataConsegnaStimata) {
        this.dataConsegnaStimata = dataConsegnaStimata;
    }

    public LocalDate getDataConsegnaEffettiva() {
        return dataConsegnaEffettiva;
    }

    public void setDataConsegnaEffettiva(LocalDate dataConsegnaEffettiva) {
        this.dataConsegnaEffettiva = dataConsegnaEffettiva;
    }

    public Integer getStatoSpedizione() {
        return statoSpedizione;
    }

    public void setStatoSpedizione(Integer statoSpedizione) {
        this.statoSpedizione = statoSpedizione;
    }

    public String getIndirizzoSpedizione() {
        return indirizzoSpedizione;
    }

    public void setIndirizzoSpedizione(String indirizzoSpedizione) {
        this.indirizzoSpedizione = indirizzoSpedizione;
    }

    public String getNoteSpedizione() {
        return noteSpedizione;
    }

    public void setNoteSpedizione(String noteSpedizione) {
        this.noteSpedizione = noteSpedizione;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdUtenteInserimento() {
        return idUtenteInserimento;
    }

    public void setIdUtenteInserimento(String idUtenteInserimento) {
        this.idUtenteInserimento = idUtenteInserimento;
    }

    public Timestamp getTsCancellazione() {
        return tsCancellazione;
    }

    public void setTsCancellazione(Timestamp tsCancellazione) {
        this.tsCancellazione = tsCancellazione;
    }

    public String getIdUtenteCancellazione() {
        return idUtenteCancellazione;
    }

    public void setIdUtenteCancellazione(String idUtenteCancellazione) {
        this.idUtenteCancellazione = idUtenteCancellazione;
    }

    public Integer getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Integer idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Timestamp getTsInserimentoOrdine() {
        return tsInserimentoOrdine;
    }

    public void setTsInserimentoOrdine(Timestamp tsInserimentoOrdine) {
        this.tsInserimentoOrdine = tsInserimentoOrdine;
    }

    @Override
    public it.interno.shipping.entity.Shipping clone() {
        try {
            it.interno.shipping.entity.Shipping clone = (it.interno.shipping.entity.Shipping) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
