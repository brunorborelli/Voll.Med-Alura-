package med.voll.api.medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
    
    public DadosListagemMedico(med.voll.api.medico.medico medico){
        this(
         medico.getId(),
         medico.getNome(),
         medico.getEmail(), 
         medico.getCrm(), 
         medico.getEspecialidade()
         );
    }

}
