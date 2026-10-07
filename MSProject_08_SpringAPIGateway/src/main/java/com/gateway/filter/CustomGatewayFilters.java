package com.gateway.filter;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

public class CustomGatewayFilters {

    private static final Logger logger =
            LoggerFactory.getLogger(CustomGatewayFilters.class);


    // ============================================================
    // 1. PRE FILTER
    // ============================================================

    public static HandlerFilterFunction<ServerResponse, ServerResponse> preFilter() {

        return (request, next) -> {

            String path = request.uri().getPath();

            logger.info("========== PRE FILTER ==========");
            logger.info("Request Method : {}", request.method());
            logger.info("Request Path   : {}", path);
            logger.info("================================");

            return next.handle(request);
        };
    }


    // ============================================================
    // 2. POST FILTER
    // ============================================================

    public static HandlerFilterFunction<ServerResponse, ServerResponse> postFilter() {

        return (request, next) -> {

            ServerResponse response = next.handle(request);

            logger.info("========== POST FILTER ==========");
            logger.info("Request Path : {}", request.uri().getPath());
            logger.info("Response Status : {}", response.statusCode());
            logger.info("=================================");

            return response;
        };
    }


    // ============================================================
    // 3. RESPONSE FILTER
    // ============================================================

    public static HandlerFilterFunction<ServerResponse, ServerResponse> responseFilter() {

        return (request, next) -> {

            ServerResponse response = next.handle(request);

            response.headers().add(
                    "X-Gateway",
                    "MSProject-07-ApiGateway"
            );

            logger.info("RESPONSE FILTER --> X-Gateway header added");

            return response;
        };
    }


    // ============================================================
    // 4. ERROR FILTER
    // ============================================================

    public static HandlerFilterFunction<ServerResponse, ServerResponse> errorFilter() {

        return (request, next) -> {

            try {

                return next.handle(request);

            } catch (Exception ex) {

                logger.error(
                        "ERROR FILTER --> Request failed: {}",
                        request.uri(),
                        ex
                );

                throw ex;
            }
        };
    }
}