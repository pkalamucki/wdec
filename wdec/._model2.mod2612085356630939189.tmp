var cena >= 0, <= 100;
var koszt_reklamy_tv >= 0, <= 100000;
var koszt_reklamy_net >= 0, <= 100000;
var koszt_reklamy_magazyny >= 0, <= 100000;
var wolumen >=0, <= 400000;
var jakosc >=8, <= 100;
var kredyt >= 0, <= 800000;
var rata >= 0;
var ryzyko >=0, <=1;
var koszt_produkcji >= 0;

var gotowka >= 0;
var przychod >= 0;
var wysokosc_podatku >= 0;
var wolna_gotowka >= 0;

param koszty_stale;
param oprocentowanie_konta;
param oprocentowanie_kredytu;
param aktualna_gotowka;
param ryzyko_max;
param podatek;
param kredyt_max;
param amortyzacja;
param ilosc_etapow_do_konca;
param zadluzenie;

maximize f_celu: gotowka;

subject to dopuszczalne_ryzyko: ryzyko <= ryzyko_max;

# RYZYKO
subject to funkcja_ryzyka: ryzyko = 0.35*(cena-15)/15 + 0.23*(100 - jakosc)/100 + 0.04*(100000 - koszt_reklamy_tv)/100000+ 0.025*(100000 - koszt_reklamy_net)/100000+ 0.035*(100000 - koszt_reklamy_magazyny)/100000;

# druga opcja
#subject to funkcja_ryzyka: ryzyko = (wolumen/40000)*0.15*(cena/jakosc) - (0.9*koszt_reklamy_tv + 0.7*koszt_reklamy_magazyny +
# 0.4*koszt_reklamy_net)/200000;

# trzecia opcja
#subject to funkcja_ryzyka: ryzyko = 0.5*(cena-15)/15 + 0.5*(100 #- jakosc)/100 + 0.06*(100000 - koszt_reklamy_tv)/100000+ 0.07*
#(100000 - koszt_reklamy_net)/100000+ 0.04*(100000 - #koszt_reklamy_magazyny)/100000;


subject to gotowka_na_koniec_etapu: gotowka = wolna_gotowka + przychod - wysokosc_podatku;

subject to wolna_gotowka_na_koniec_etapu: wolna_gotowka = aktualna_gotowka+kredyt-rata-amortyzacja-koszt_reklamy_tv-koszt_reklamy_net-koszt_reklamy_magazyny-koszty_stale-wolumen*koszt_produkcji;
subject to przychod_na_koniec_etapu: przychod = wolumen*cena + wolna_gotowka*oprocentowanie_konta;
subject to _podatek: wysokosc_podatku = przychod*podatek;
subject to plynnosc: wolna_gotowka >= amortyzacja + koszty_stale;

subject to wysokosc_raty: rata = (kredyt + zadluzenie)*oprocentowanie_kredytu + (kredyt + zadluzenie)/ilosc_etapow_do_konca;
subject to zdolnosc_kredytowa: kredyt <= kredyt_max - zadluzenie;

subject to koszty_produkcji: koszt_produkcji = 0.000014*jakosc^3 - 0.0017663*jakosc^2 + 0.0965*jakosc + 6.78476+ 0.000003*wolumen;
