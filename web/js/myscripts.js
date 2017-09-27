/* 
 * EEEEEOOOOOOOQQ?????
 */

function mascara(t, mask) {
    var i = t.value.length;
    var saida = mask.substring(1, 0);
    var texto = mask.substring(i)
    if (texto.substring(0, 1) != saida) {
        t.value += texto.substring(0, 1);
    }
}

function SomenteNumero(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58))
        return true;
    else {
        if (tecla == 8 || tecla == 0)
            return true;
        else
            return false;
    }
}


function maskCPF(CPF) {
    var evt = window.event;
    kcode = evt.keyCode;
    if (kcode == 8)
        return;
    if (CPF.value.length == 3) {
        CPF.value = CPF.value + '.';
    }
    if (CPF.value.length == 7) {
        CPF.value = CPF.value + '.';
    }
    if (CPF.value.length == 11) {
        CPF.value = CPF.value + '-';
    }
}

    function validaCPF() {
        var cpf = document.getElementById("cpf")
        erro = new String;

        if (cpf.value.length == 14) {
            cpf.value = cpf.value.replace('.', '');
            cpf.value = cpf.value.replace('.', '');
            cpf.value = cpf.value.replace('-', '');

            var nonNumbers = /\D/;

            if (nonNumbers.test(cpf.value)) {
                erro = "A verificacao de CPF suporta apenas números!";
            } else {
                if (cpf.value == "00000000000" ||
                        cpf.value == "11111111111" ||
                        cpf.value == "22222222222" ||
                        cpf.value == "33333333333" ||
                        cpf.value == "44444444444" ||
                        cpf.value == "55555555555" ||
                        cpf.value == "66666666666" ||
                        cpf.value == "77777777777" ||
                        cpf.value == "88888888888" ||
                        cpf.value == "99999999999") {

                    erro = "Número de CPF inválido!"
                }

                var a = [];
                var b = new Number;
                var c = 11;

                for (i = 0; i < 11; i++) {
                    a[i] = cpf.value.charAt(i);
                    if (i < 9)
                        b += (a[i] * --c);
                }

                if ((x = b % 11) < 2) {
                    a[9] = 0
                } else {
                    a[9] = 11 - x
                }
                b = 0;
                c = 11;

                for (y = 0; y < 10; y++)
                    b += (a[y] * c--);

                if ((x = b % 11) < 2) {
                    a[10] = 0;
                } else {
                    a[10] = 11 - x;
                }

                if ((cpf.value.charAt(9) != a[9]) || (cpf.value.charAt(10) != a[10])) {
                    erro = "Número de CPF inválido.";
                }
            }
        } else
        {
            if (cpf.value.length == 0)
                return false
            else
                erro = "Número de CPF inválido.";
        }
        if (erro.length > 0) {
            alert(erro);
            cpf.value = "";
           // cpf.focus();
            return false;
        }
        return true; //se chegou aqui deu boa
    }


    function valida_nome() {
        var filter_nome = /^([a-zA-Zà-úÀ-Ú]|\s+)+$/;
        var nome = document.getElementById("input_nome")
        if (!filter_nome.test(nome.value)) {
            alert("ATENÇÂO! \n Campo Nome não pode conter carácteres especiais!")
            nome.value = '';
            return false;
        }
        return true;
    }
    
    
    
    /*
      function chama_alerta(nome) {
                alert(nome.value);
            }

            function chama_alerta2() {
                var nome = document.getElementById("input_nome");
                alert(nome.value);
                nome.value = "";
                //document.getElementById("input_nome").focus();
            }

            function valida_nome() {
                var nome = document.getElementById("input_nome");
                
                var filter_nome = /^([a-zA-Zà-úÀ-Ú]|\s+)+$/;
                
                if (!filter_nome.test(nome.value)) {
                    nome.value = '';
                    nome.placeholder = "Nome inválido";
                    nome.style.borderColor = "#ff0000";
                    nome.style.outline = "#ff0000";
                    nome.focus();
                    return false;
                }
                return true;
            }


    function valida_nome() {
        var filter_nome = /^([a-zA-Zà-úÀ-Ú]|\s+)+$/;
        if (!filter_nome.test(document.getElementById("input_nome").value)) {
            document.getElementById("input_nome").value = '';
            document.getElementById("input_nome").placeholder = "Nome inválido";
            document.getElementById("input_nome").style.borderColor = "#ff0000";
            document.getElementById("input_nome").style.outline = "#ff0000";
            document.getElementById("input_nome").focus();
            document.getElementById("input_nome").onkeydown = function keydown_nome() {
                document.getElementById("input_nome").placeholder = "";
                document.getElementById("input_nome").style.borderColor = "#999999";
                document.getElementById("input_nome").style.outline = null;
            }
            return false;
        } 
        return true;
    }

function somente_letras() {
        var filter_nome = /^([a-zA-Zà-úÀ-Ú]|\s+)+$/;
        if (!filter_nome.test(document.getElementById("input_nome").value)) {
            alert("ATENÇÂO! \n Campo Nome não pode conter carácteres especiais!")
            document.getElementById("input_nome").value = '';
            document.getElementById("input_nome").focus();
            
            return false;
        } 
        return true;
    }
    */