package br.ufpb.dcx.aps.atividades.atv06;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Formulario {
    private String titulo;
    private Map<String, Campo> campos = new LinkedHashMap<>();

    public Formulario(){

        this.titulo = "";
    }
    public Formulario(String titulo){

        this.titulo = titulo;
    }
    public String getTitulo(){

        return titulo;
    }
    public void setTitulo(String titulo){

        this.titulo = titulo;
    }
    public Campo getCampo(String id) {

        return campos.get(id);
    }
    public void addCampo(Campo campo) {
        if (campos.containsKey(campo.getId())){
            throw new RuntimeException("Já existe um campo com este id:'"+campo.getId()+"'");
        }
        campos.put(campo.getId(),campo);
    }

    public Collection<Campo> getCampos() {

        return campos.values();
    }

    public Resultado validar(){
        Resultado r = new Resultado();
        for (Campo c: campos.values()){
            if (c.validar().isErro()){
                r.setErro(true);
                for (String msg: c.validar().getMensagens()){
                    r.addMensagem("Campo " + c.getId() + ": " +msg);
                }
            }
        }
        return r;
    }

}
