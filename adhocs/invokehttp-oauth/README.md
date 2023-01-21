Download the template and upload into NiFi instance

### Introduction

This example demonstrates how to run oauth token apis with InvokeHTTP processsor. Also, to demonstrate the oauth token generation process, there is spring boot application [developed](./spring-boot-oauth-example/).

### Configuring Processors and Controller Services

***InvokeHTTP***

| Name | Value |
| ---- | ----- |
| HTTP Method | `GET` |
| Remote URL | `http://localhost:9001/access/token` |

Dynamic Properties

| Name | Value |
| ---- | ----- |
| Authorization | `Basic bmlmaV91c2VyOmF3ZXNvbWVfbmlmaQ==` |

***EvaluateJSONPath***

| Name | Value |
| ---- | ----- |
| Destination | `flowfile-attribute` |

Dynamic Properties

| Name | Value |
| ---- | ----- |
| access_token | `$.access_token` |


***ReplaceText***

| Name | Value |
| ---- | ----- |
| Replacement Value | `{ "name": "Mark", "age": 25, "address": "California, USA"}` |
| Replacement Strategy | `Always Replace` |
| Evaluation Mode | `Entire text` |

***InvokeHTTP***

| Name | Value |
| ---- | ----- |
| HTTP Method | `POST` |
| Remote URL | `http://localhost:9001/employee` |

Dynamic Properties

| Name | Value |
| ---- | ----- |
| Authorization | `${access_token:prepend('Bearer ')}` |