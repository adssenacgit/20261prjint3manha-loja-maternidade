package br.senac.prjint3.exception;

import java.time.LocalDateTime;

public record ApiError(
        LocalDateTime dataHora,
        int status,
        String erro,
        String mensagem,
        String path
) {
}
