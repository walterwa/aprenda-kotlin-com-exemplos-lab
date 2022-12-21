
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val identidade: Long)

data class ConteudoEducacional(var nome: String, var duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    infix fun matricular(usuario: Usuario) { inscritos.add(usuario) }
    
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios)
       		inscritos.add(usuario)
    }
    
    fun gradeConteudos(){ 
        for (conteudo in conteudos)
        	println(conteudo.nome)
    }
    
    fun listaInscritos() { 
        for (inscrito in inscritos)
        	println("${inscrito.nome} ${inscrito.identidade}")
    }
}

fun main() {
        
    //criando usuários
    val arnaldo = Usuario("Alberto", 123)
    val tereza = Usuario("Tereza", 987)
    val celio = Usuario("Célio", 100)
    
    
   
    // adicionando o conteúdo da disciplina da formação
    val listaConteudosAntropologia:List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Introdução à Teoria Antropológica"),
        ConteudoEducacional("Teoria Antropológica II"),
        ConteudoEducacional("História do Brasil"),
        ConteudoEducacional("Cultura Popular")
    )
    
    //criando a formação
    val antropologia = Formacao("Antropologia", listaConteudosAntropologia, Nivel.BASICO)
    
    //matriculando
        antropologia.matricular(arnaldo)
        antropologia.matricular(tereza)
        antropologia.matricular(celio)
   
    
    //print do resultado final com os testes
    println("*-**-* Formação: ${antropologia.nome} *-**-**-*")
    println("Conteúdos: \n")
    antropologia.gradeConteudos()
    println(" ")
    println("Lista de inscritos: \nNome | Identidade: \n")
    antropologia.listaInscritos()
}
