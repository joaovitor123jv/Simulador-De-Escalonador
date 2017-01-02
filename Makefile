#Makefile JAVA, não faça caca tentando compilar C ou C++ com isso, sir JV


#####		PASTAS

PASTA_CODIGOS=src
PASTA_BINARIOS=bin

PASTA_ESCALONADOR=Escalonador
PASTA_GERAL=Geral
PASTA_INTERFACE=Interface

######		ARQUIVOS
MAIN=Main.java

######		Variáveis necessárias para compilação

COMPILADOR=javac
JAVA=java
DEFINE_DIRETORIO_DE_COMPILADOS=-d


######		Regras
all: $(MAIN)
	@echo "Compilação terminada com sucesso!"

debug:

run:
	cd $(PASTA_BINARIOS); $(JAVA) $(MAIN:.java=)


$(MAIN):
	$(COMPILADOR) $(PASTA_CODIGOS)/$(MAIN) $(DEFINE_DIRETORIO_DE_COMPILADOS) $(PASTA_BINARIOS)
