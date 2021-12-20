PGDMP         "                 y            SimpleBanking    13.2    13.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16470    SimpleBanking    DATABASE     l   CREATE DATABASE "SimpleBanking" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE "SimpleBanking";
                postgres    false            �            1259    16495    account    TABLE     �   CREATE TABLE public.account (
    id integer NOT NULL,
    owner character varying,
    account_number character varying,
    balance double precision
);
    DROP TABLE public.account;
       public         heap    postgres    false            �            1259    16493    account_id_seq    SEQUENCE     �   CREATE SEQUENCE public.account_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.account_id_seq;
       public          postgres    false    201            �           0    0    account_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.account_id_seq OWNED BY public.account.id;
          public          postgres    false    200            �            1259    16506    transaction    TABLE     ,  CREATE TABLE public.transaction (
    id integer NOT NULL,
    date timestamp without time zone,
    amount double precision,
    type character varying,
    approval_code character varying,
    account_id integer,
    operator_name character varying(255),
    phone_number character varying(255)
);
    DROP TABLE public.transaction;
       public         heap    postgres    false            �            1259    16504    transaction_id_seq    SEQUENCE     �   CREATE SEQUENCE public.transaction_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.transaction_id_seq;
       public          postgres    false    203            �           0    0    transaction_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.transaction_id_seq OWNED BY public.transaction.id;
          public          postgres    false    202            *           2604    16498 
   account id    DEFAULT     h   ALTER TABLE ONLY public.account ALTER COLUMN id SET DEFAULT nextval('public.account_id_seq'::regclass);
 9   ALTER TABLE public.account ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    200    201    201            +           2604    16509    transaction id    DEFAULT     p   ALTER TABLE ONLY public.transaction ALTER COLUMN id SET DEFAULT nextval('public.transaction_id_seq'::regclass);
 =   ALTER TABLE public.transaction ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            �          0    16495    account 
   TABLE DATA           E   COPY public.account (id, owner, account_number, balance) FROM stdin;
    public          postgres    false    201   w       �          0    16506    transaction 
   TABLE DATA           u   COPY public.transaction (id, date, amount, type, approval_code, account_id, operator_name, phone_number) FROM stdin;
    public          postgres    false    203   �       �           0    0    account_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.account_id_seq', 1, true);
          public          postgres    false    200            �           0    0    transaction_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.transaction_id_seq', 13, true);
          public          postgres    false    202            -           2606    16503    account account_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.account DROP CONSTRAINT account_pkey;
       public            postgres    false    201            /           2606    16514    transaction transaction_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.transaction DROP CONSTRAINT transaction_pkey;
       public            postgres    false    203            0           2606    16515    transaction transaction_fk    FK CONSTRAINT     ~   ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_fk FOREIGN KEY (account_id) REFERENCES public.account(id);
 D   ALTER TABLE ONLY public.transaction DROP CONSTRAINT transaction_fk;
       public          postgres    false    201    203    2861            �   &   x�3��N-J�U�N,JLN�44��4�01������ ~��      �   �   x�]�=N�@��z�\����g&)5�A���j#��FBܞP+������#���pr4(EC�h���v���kZo��󶚎9���f��AR�BG����nȜ�����}����7o�~��������R�*6R�!6�!��G'E���7i���hN�mm����{[�=¾Kf���;�R��'↹���n5��bTUDb��k�7�Q�     