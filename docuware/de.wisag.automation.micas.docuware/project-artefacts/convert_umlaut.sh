#!/bin/bash

AE_L=`echo -e "\x84"`
AE_U=`echo -e "\x8E"`
OE_L=`echo -e "\x94"`
OE_U=`echo -e "\x99"`
UE_L=`echo -e "\x81"`
UE_U=`echo -e "\x9a"`
sed 's/'$AE_L'/ae/g;s/'$AE_U'/Ae/g;s/'$OE_L'/oe/g;s/'$OE_U'/Oe/g;s/'$UE_L'/ue/g;s/'$UE_U'/Ue/g' $1
