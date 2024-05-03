# T2 Compiladores

O trabalho 2 (T2) da disciplina consiste em implementar um analisador sintático para a linguagem LA (Linguagem Algorítmica) desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar. O analisador sintático deve ler um programa-fonte e apontar onde existe erro sintático, indicando a linha e o lexema que causou a detecção do erro.

## Alunos
- Bruno Zenatti de Caires Marcelo RA: 769821
- Giovani Guidini RA: 790862

## 🚀 Começando

Para executar o projeto em sua máquina local, siga os passos abaixo.

### 📋 Pré-requisitos

Você precisa ter instalado em sua máquina:

- Java JDK 8 ou superior passos abaixo.

### 📋 Pré-requisitos

- Apache Maven

### 🔧 Instalação

1. Clone este repositório
   
```
git clone https://github.com/bztNTC/Compiladores-T2.git
```

2. Navegue até o diretório do projeto

```
cd seu-repositorio
```

3. Compile o projeto com Maven
   
```
mvn package
```

## ⚙️ Executando os casos testes

Para executar o corretor automatico voce precisara de sete argumentos para ser executado.
Exemplo:
```
java -jar C:\Users\bruno\Documents\Compiladores\Corretor\compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar C:\Users\bruno\Documents\Compiladores\CompiladoresT2\compt2\target\compt2-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc C:\Windows\Temp C:\Users\bruno\Documents\Compiladores\casos-de-teste "769821, 790862" "t2"
```

- ARG1 = Instalação do corretor
  Faça download do arquivo executável do corretor e salve em algum diretório local: compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar (ex: c:\corretor\compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar)

- ARG2 = Caminho executável do seu compilador, com aspas (ex: "java -jar c:\meuComp\meucomp.jar") - se estiver usando Java (ex: "c:\meuComp\meucomp.exe") - se estiver usando executável windows (outras linguagens também podem ser utilizadas. Utilize o comando executável apropriado) (IMPORTANTE: o Java pode não funcionar muito bem com diretórios que contém espaços em branco, ou diretórios muito longos. Se não estiver funcionando, experimente utilizar somente diretórios sem espaços no nome) (IMPORTANTE 2: lembre-se de incluir o caminho ABSOLUTO A PARTIR DA RAIZ DO DISCO, e não o caminho RELATIVO, caso contrário o corretor não conseguirá executar corretamente)

- ARG3 = Compilador GCC. Linux e MacOS já o possuem na sua instalação padrão. Para windows, pode ser instalado o MINGW: (http://www.mingw.org/). Anote o caminho executável do seu gcc. O ideal é que ele esteja na variável de ambiente "PATH", assim, o caminho é apenas o nome gcc (ex: gcc)

- ARG4 = Uma pasta temporária. Essa pasta irá conter os arquivos gerados durante o processo (ex: c:\temp)

- ARG5 = Casos de teste. Faça download do arquivo casos-de-teste.zip, e descompacte-o em alguma pasta (ex: c:\casos-de-teste)

- ARG6 = RAs do grupo, com aspas (ex: "769821, 790862")

- ARG7 = Opção de correção (ex: "t1")
