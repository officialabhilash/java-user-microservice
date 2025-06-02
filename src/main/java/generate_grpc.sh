#!/usr/bin/env bash

protoc   -I=com/example/user/users/grpc/protos   --java_out=.  com/example/user/users/grpc/protos/order_service.proto
protoc   -I=com/example/user/users/grpc/protos   --java_out=. --grpc-java_out=.  com/example/user/users/grpc/protos/user_service.proto
