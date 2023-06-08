package br.com.apyetro;
import java.util.Map;
import java.util.HashMap;

public class BoletimEscolar {

        private Map<String, Double> notas;
        private double notaMinimaAprovacao;

        public BoletimEscolar(double notaMinimaAprovacao) {
            notas = new HashMap<>();
            this.notaMinimaAprovacao = notaMinimaAprovacao;
        }

        public void adicionarNota(String materia, double nota) {
            notas.put(materia, nota);
        }

        public double obterNota(String materia) {
            return notas.getOrDefault(materia, 0.0);
        }

        public String verificarStatus(String materia) {
            double nota = obterNota(materia);

            if (nota >= notaMinimaAprovacao) {
                return "Aprovado";
            } else {
                return "Reprovado";
            }
        }

        public static void main(String[] args) {
            BoletimEscolar boletim = new BoletimEscolar(6.0);

            boletim.adicionarNota("Matemática", 9.0);
            boletim.adicionarNota("História", 8.5);
            boletim.adicionarNota("Ciências", 7.0);


            System.out.println("Nota de Matemática: " + boletim.obterNota("Matemática") + " - " + boletim.verificarStatus("Matemática"));
            System.out.println("Nota de História: " + boletim.obterNota("História") + " - " + boletim.verificarStatus("História"));
            System.out.println("Nota de Ciências: " + boletim.obterNota("Ciências") + " - " + boletim.verificarStatus("Ciências"));
            System.out.println("Nota de Português: " + boletim.obterNota("Português") + " - " + boletim.verificarStatus("Português")); // Matéria não adicionada, retorna o valor padrão 0.0 e "Reprovado"
        }
}


