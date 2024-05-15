package org.grupo6.main.Resena.DTO;
public class ResenaDTO {

    private Long usuarioId;
    private Long reservaId;
    private String comentario;
    private int valoracion;

    public ResenaDTO() {
    }

    public ResenaDTO(Long usuarioId, Long reservaId, String comentario, int valoracion) {
        this.usuarioId = usuarioId;
        this.reservaId = reservaId;
        this.comentario = comentario;
        this.valoracion = valoracion;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}
