-- we don't know how to generate root <with-no-name> (class Root) :(
create table uporabnik
(
	id serial not null
		constraint uporabnik_pk
			primary key,
	ime_uporabnika varchar
);

alter table uporabnik owner to postgres;

create table slika
(
	id serial not null
		constraint slika_pk
			primary key,
	datum_nastanka_slike date,
	url_slike varchar,
	ime_slike varchar,
	id_uporabnik integer
		constraint slika_uporabnik_id_fk
			references uporabnik
				on update cascade on delete cascade
);

alter table slika owner to postgres;

create unique index slika_id_uindex
	on slika (id);

create unique index uporabnik_id_uindex
	on uporabnik (id);

create unique index uporabnik_ime_uporabnika_uindex
	on uporabnik (ime_uporabnika);

create table album
(
	id serial not null
		constraint album_pk
			primary key,
	ime_albuma varchar,
	datum_nastanka_albuma date,
	id_uporabnik integer
		constraint album_uporabnik_id_fk
			references uporabnik
				on update cascade on delete cascade
				deferrable initially deferred
);

alter table album owner to postgres;

create unique index album_id_uindex
	on album (id);

create table slika_album
(
	id_slika integer
		constraint slika_album_slika_id_fk
			references slika
				on update cascade on delete cascade,
	id_album integer
		constraint slika_album_album_id_fk
			references album
				on update cascade on delete cascade,
	id serial not null
		constraint slika_album_pk
			primary key
);

alter table slika_album owner to postgres;

create unique index slika_album_id_uindex
	on slika_album (id);

create table komentar
(
	id serial not null
		constraint komentar_pk
			primary key,
	id_slika integer
		constraint komentar_slika_id_fk
			references slika
				on update cascade on delete cascade,
	id_uporabnik integer
		constraint komentar_uporabnik_id_fk
			references uporabnik
				on update cascade on delete cascade,
	vsebina varchar,
	datum_nastanka_komentarja date
);

alter table komentar owner to postgres;

create unique index komentar_id_uindex
	on komentar (id);

