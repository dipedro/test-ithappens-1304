--
-- PostgreSQL database dump
--

-- Dumped from database version 10.10
-- Dumped by pg_dump version 12.2

-- Started on 2020-06-30 22:13:57

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2888 (class 1262 OID 66328)
-- Name: mateus; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE mateus WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE mateus OWNER TO postgres;

\connect mateus

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- TOC entry 198 (class 1259 OID 83200)
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    id bigint NOT NULL,
    nome character varying(255) NOT NULL
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 83198)
-- Name: clientes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.clientes ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.clientes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 200 (class 1259 OID 83207)
-- Name: estoque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estoque (
    id bigint NOT NULL,
    quantidade integer NOT NULL,
    filial_id bigint NOT NULL,
    produto_id bigint NOT NULL
);


ALTER TABLE public.estoque OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 83205)
-- Name: estoque_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.estoque ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.estoque_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 202 (class 1259 OID 83214)
-- Name: filiais; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.filiais (
    id bigint NOT NULL,
    nome character varying(255) NOT NULL
);


ALTER TABLE public.filiais OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 83212)
-- Name: filiais_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.filiais ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.filiais_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 204 (class 1259 OID 83221)
-- Name: formas_pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.formas_pagamento (
    id bigint NOT NULL,
    nome character varying(255) NOT NULL
);


ALTER TABLE public.formas_pagamento OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 83219)
-- Name: formas_pagamento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.formas_pagamento ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.formas_pagamento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 196 (class 1259 OID 66334)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 83228)
-- Name: itens_pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.itens_pedido (
    id bigint NOT NULL,
    quantidade integer NOT NULL,
    status character varying(255) NOT NULL,
    pedido_estoque_id bigint NOT NULL,
    produto_id bigint NOT NULL
);


ALTER TABLE public.itens_pedido OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 83226)
-- Name: itens_pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.itens_pedido ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.itens_pedido_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 208 (class 1259 OID 83235)
-- Name: pedidos_estoque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedidos_estoque (
    id bigint NOT NULL,
    observacao character varying(255) NOT NULL,
    tipo character varying(255) NOT NULL,
    cliente_id bigint NOT NULL,
    filial_id bigint NOT NULL,
    forma_pagamento_id bigint NOT NULL,
    usuario_id bigint NOT NULL
);


ALTER TABLE public.pedidos_estoque OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 83233)
-- Name: pedidos_estoque_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.pedidos_estoque ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.pedidos_estoque_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 210 (class 1259 OID 83245)
-- Name: produtos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produtos (
    id bigint NOT NULL,
    codigo_de_barras character varying(255) NOT NULL,
    descricao character varying(255) NOT NULL,
    valor numeric(19,2) NOT NULL
);


ALTER TABLE public.produtos OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 83243)
-- Name: produtos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.produtos ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.produtos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 212 (class 1259 OID 83255)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id bigint NOT NULL,
    cpf character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    senha character varying(255) NOT NULL
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 83253)
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.usuarios ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2868 (class 0 OID 83200)
-- Dependencies: 198
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.clientes (id, nome) VALUES (1, 'Brenda Emmylly');
INSERT INTO public.clientes (id, nome) VALUES (2, 'Pedro Azevedo');
INSERT INTO public.clientes (id, nome) VALUES (3, 'Julliana RH');


--
-- TOC entry 2870 (class 0 OID 83207)
-- Dependencies: 200
-- Data for Name: estoque; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2872 (class 0 OID 83214)
-- Dependencies: 202
-- Data for Name: filiais; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.filiais (id, nome) VALUES (1, 'Mateus Cohama');
INSERT INTO public.filiais (id, nome) VALUES (2, 'Mateus Cohab');
INSERT INTO public.filiais (id, nome) VALUES (3, 'Mateus Renascença');


--
-- TOC entry 2874 (class 0 OID 83221)
-- Dependencies: 204
-- Data for Name: formas_pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.formas_pagamento (id, nome) VALUES (1, 'A VISTA');
INSERT INTO public.formas_pagamento (id, nome) VALUES (2, 'BOLETO');
INSERT INTO public.formas_pagamento (id, nome) VALUES (3, 'CARTAO');


--
-- TOC entry 2876 (class 0 OID 83228)
-- Dependencies: 206
-- Data for Name: itens_pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2878 (class 0 OID 83235)
-- Dependencies: 208
-- Data for Name: pedidos_estoque; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2880 (class 0 OID 83245)
-- Dependencies: 210
-- Data for Name: produtos; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2882 (class 0 OID 83255)
-- Dependencies: 212
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuarios (id, cpf, nome, senha) VALUES (1, '05289665374', 'Pedro da Silva Azevedo', '123456');
INSERT INTO public.usuarios (id, cpf, nome, senha) VALUES (2, '99999999999', 'Usuario 2', '123456');
INSERT INTO public.usuarios (id, cpf, nome, senha) VALUES (3, '00000000000', 'Usuario 3', '123456');


--
-- TOC entry 2889 (class 0 OID 0)
-- Dependencies: 197
-- Name: clientes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_id_seq', 3, true);


--
-- TOC entry 2890 (class 0 OID 0)
-- Dependencies: 199
-- Name: estoque_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estoque_id_seq', 1, false);


--
-- TOC entry 2891 (class 0 OID 0)
-- Dependencies: 201
-- Name: filiais_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.filiais_id_seq', 3, true);


--
-- TOC entry 2892 (class 0 OID 0)
-- Dependencies: 203
-- Name: formas_pagamento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.formas_pagamento_id_seq', 3, true);


--
-- TOC entry 2893 (class 0 OID 0)
-- Dependencies: 196
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 36, true);


--
-- TOC entry 2894 (class 0 OID 0)
-- Dependencies: 205
-- Name: itens_pedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.itens_pedido_id_seq', 1, false);


--
-- TOC entry 2895 (class 0 OID 0)
-- Dependencies: 207
-- Name: pedidos_estoque_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedidos_estoque_id_seq', 1, false);


--
-- TOC entry 2896 (class 0 OID 0)
-- Dependencies: 209
-- Name: produtos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produtos_id_seq', 1, false);


--
-- TOC entry 2897 (class 0 OID 0)
-- Dependencies: 211
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_seq', 3, true);


--
-- TOC entry 2718 (class 2606 OID 83204)
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id);


--
-- TOC entry 2720 (class 2606 OID 83211)
-- Name: estoque estoque_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT estoque_pkey PRIMARY KEY (id);


--
-- TOC entry 2722 (class 2606 OID 83218)
-- Name: filiais filiais_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.filiais
    ADD CONSTRAINT filiais_pkey PRIMARY KEY (id);


--
-- TOC entry 2724 (class 2606 OID 83225)
-- Name: formas_pagamento formas_pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formas_pagamento
    ADD CONSTRAINT formas_pagamento_pkey PRIMARY KEY (id);


--
-- TOC entry 2726 (class 2606 OID 83232)
-- Name: itens_pedido itens_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_pedido
    ADD CONSTRAINT itens_pedido_pkey PRIMARY KEY (id);


--
-- TOC entry 2728 (class 2606 OID 83242)
-- Name: pedidos_estoque pedidos_estoque_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos_estoque
    ADD CONSTRAINT pedidos_estoque_pkey PRIMARY KEY (id);


--
-- TOC entry 2730 (class 2606 OID 83252)
-- Name: produtos produtos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produtos
    ADD CONSTRAINT produtos_pkey PRIMARY KEY (id);


--
-- TOC entry 2734 (class 2606 OID 83266)
-- Name: usuarios uk_2et2smpfrtsohr7w9fe1v8a5e; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT uk_2et2smpfrtsohr7w9fe1v8a5e UNIQUE (cpf);


--
-- TOC entry 2732 (class 2606 OID 83264)
-- Name: produtos uk_5evj0yd63s0941o8lj8jm0bnf; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produtos
    ADD CONSTRAINT uk_5evj0yd63s0941o8lj8jm0bnf UNIQUE (codigo_de_barras);


--
-- TOC entry 2736 (class 2606 OID 83262)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 2742 (class 2606 OID 83292)
-- Name: pedidos_estoque fkf2s0d7qhl5ek8n9xmdgwtv4w4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos_estoque
    ADD CONSTRAINT fkf2s0d7qhl5ek8n9xmdgwtv4w4 FOREIGN KEY (filial_id) REFERENCES public.filiais(id);


--
-- TOC entry 2739 (class 2606 OID 83277)
-- Name: itens_pedido fkflc6i1b2v792lfcc3q6tq22dl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_pedido
    ADD CONSTRAINT fkflc6i1b2v792lfcc3q6tq22dl FOREIGN KEY (pedido_estoque_id) REFERENCES public.pedidos_estoque(id);


--
-- TOC entry 2737 (class 2606 OID 83267)
-- Name: estoque fkfogsklnk0vsnpks04n8skgxic; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT fkfogsklnk0vsnpks04n8skgxic FOREIGN KEY (filial_id) REFERENCES public.filiais(id);


--
-- TOC entry 2743 (class 2606 OID 83297)
-- Name: pedidos_estoque fkft44af47tdmebxohf5tvml0xy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos_estoque
    ADD CONSTRAINT fkft44af47tdmebxohf5tvml0xy FOREIGN KEY (forma_pagamento_id) REFERENCES public.formas_pagamento(id);


--
-- TOC entry 2741 (class 2606 OID 83287)
-- Name: pedidos_estoque fkgjf5n1jiagwwmjq1b9ri3b2b5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos_estoque
    ADD CONSTRAINT fkgjf5n1jiagwwmjq1b9ri3b2b5 FOREIGN KEY (cliente_id) REFERENCES public.clientes(id);


--
-- TOC entry 2744 (class 2606 OID 83302)
-- Name: pedidos_estoque fkhd4x9baoabaic7ui0ikivob8m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos_estoque
    ADD CONSTRAINT fkhd4x9baoabaic7ui0ikivob8m FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);


--
-- TOC entry 2738 (class 2606 OID 83272)
-- Name: estoque fkmonotpf9w7pfuomk89nqxgeq1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT fkmonotpf9w7pfuomk89nqxgeq1 FOREIGN KEY (produto_id) REFERENCES public.produtos(id);


--
-- TOC entry 2740 (class 2606 OID 83282)
-- Name: itens_pedido fkxytdlekpdaobqphujy9bmuhl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_pedido
    ADD CONSTRAINT fkxytdlekpdaobqphujy9bmuhl FOREIGN KEY (produto_id) REFERENCES public.produtos(id);


-- Completed on 2020-06-30 22:13:58

--
-- PostgreSQL database dump complete
--

