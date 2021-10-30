package br.com.diditalinnovation.apidatahora.exceptions;

import java.time.LocalDateTime;

public class Error {

        private LocalDateTime dateTimeError;
        private String message;

        public Error() {
        }

        public static br.com.diditalinnovation.apidatahora.exceptions.Error newBuilder() {
            return new br.com.diditalinnovation.apidatahora.exceptions.Error();
        }

        public br.com.diditalinnovation.apidatahora.exceptions.Error withDateTimeError(final LocalDateTime dateTimeError) {
            this.dateTimeError = dateTimeError;
            return this;
        }

        public br.com.diditalinnovation.apidatahora.exceptions.Error withMessage(final String message) {
            this.message = message;
            return this;
        }

        public LocalDateTime getDateTimeError() {
            return dateTimeError;
        }

        public void setDateTimeError(LocalDateTime dateTimeError) {
            this.dateTimeError = dateTimeError;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
}
