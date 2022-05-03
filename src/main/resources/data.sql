
create table public.address(
    id int4 not null,
    zipcode int not null,
    street varchar(500) not null,
    unit_number int not null,

    constraint pk_address primary key (id)
);

create table public.user(
    id int4 not null,
    email varchar(200) not null unique,
    password varchar(500) not null,
    address_id int4,

    constraint pk_user primary key (id),
    constraint fk_address_user foreign key(address_id) references public.address(id)
);

create table public.hospital(
     id int4 not null,
     nome varchar(200) not null,
     address_id int4,

     constraint pk_hospital primary key(id),
     constraint fk_address_hospital foreign key (address_id) references public.address(id)
);

create table public.contact(
    id int4 not null,
    cell_phone_number bigint not null,
    user_id int4,
    hospital_id int4,

    constraint pk_contact primary key(id),
    constraint fk_contact_user foreign key (user_id) references public.user(id),
    constraint fk_contact_hospital foreign key (hospital_id) references public.hospital(id)
);


create table public.duty(
    id int4 not null,
    user_id int4 not null,
    hospital_id int4,
    duty_date date not null,
    duty_schedule int not null,

    constraint pk_duty primary key (id),
    constraint fk_user_duty foreign key (user_id) references public.user(id),
    constraint fk_hospital_duty foreign key (hospital_id) references public.hospital(id)
);