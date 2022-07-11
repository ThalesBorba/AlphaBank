package com.foursys.fourcamp.alphabank.exceptions;

import org.springframework.http.ResponseEntity;

public abstract class Handler {


    public static ResponseEntity<Object> exceptionHandler(ResponseEntity<Object> responseEntity) {
        //try {
            return responseEntity; /*
        } catch (SpecificException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseModel(HttpStatus.BAD_REQUEST,
                    HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        } catch (SpecificException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (SpecificException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (SpecificException e) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        } catch (SpecificException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        } catch (SpecificException e) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(new ResponseModel(HttpStatus.
                    TOO_MANY_REQUESTS, HttpStatus.TOO_MANY_REQUESTS.value(), e.getMessage()));
        } catch (SpecificException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel(HttpStatus.
                    INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }*/
    }
}
