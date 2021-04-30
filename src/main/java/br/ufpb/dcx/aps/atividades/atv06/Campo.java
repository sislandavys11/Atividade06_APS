package br.ufpb.dcx.aps.atividades.atv06;

public class Campo {
    private String nome;
    private String id;
    private String valor;
    private  boolean obrigatorio;


    public Campo(String id){
        this.id = id;
        this.nome = "";
        this.valor = "";
        this.obrigatorio = false;
    }
    public Campo(String id, boolean obrigatorio){
        this(id);
        this.nome = "";
        this.valor = "";
        this.obrigatorio = obrigatorio;
    }

    public Campo(String id, String nome){
        this(id);
        this.nome = nome;
        this.valor = "";
        this.obrigatorio = false;
    }
    public Campo(String id, boolean obrigatorio, String nome){
        this(id);
        this.obrigatorio = obrigatorio;
        this.nome = nome;
        this.valor = "";

    }


    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getId() {

        return id;
    }

    public String getValor() {

        return valor;
    }

    public void setValor(String valor) {

        this.valor = valor;
    }

    public boolean isPreenchido(){
        if (getValor() == ""){
            return false;
        }
        return true;
    }

    public  boolean isObrigatorio(){
        if (obrigatorio == false){
            return false;
        }
        return true;
    }

    public Resultado validar(){
        Resultado r = new Resultado();
        if (this.obrigatorio  && !isPreenchido()){
            r.setErro(true);
            r.addMensagem("Este campo é obrigatório e não foi preenchido");
        }
        return r;
    }

    public void setObrigatorio(boolean obrigatorio) {

        this.obrigatorio = obrigatorio;
    }
}
