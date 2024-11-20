// Função para editar uma nota
function editarNota() {
        // Solicita o ID da nota ao usuário
        let notaId = prompt("Digite o ID da nota que você deseja editar:");

        // Verifica se o ID foi preenchido corretamente
        if (notaId && notaId.trim() !== "") {
            if (!isNaN(notaId)) {
                // Redireciona para o JSP passando o ID como parâmetro
                window.location.href = `editarNota.jsp?editNum=${notaId.trim()}`;
            } else {
                alert("Por favor, digite um número válido.");
            }
        } else {
            alert("Você não inseriu um ID válido.");
        }
    }

// Função para apagar uma nota
function apagarNota() {
    const notaId = prompt("Digite o ID da nota que você deseja apagar:");
    if (notaId) {
        const confirmacao = confirm(`Tem certeza que deseja apagar a nota com ID ${notaId}?`);
        if (confirmacao) {
            // Submete o ID para o endpoint de exclusão
            const form = document.createElement("form");
            form.method = "post";
            form.action = "DeleteNota";

            const input = document.createElement("input");
            input.type = "hidden";
            input.name = "delNum";
            input.value = notaId;

            form.appendChild(input);
            document.body.appendChild(form);

            form.submit();
        }
    }
}
