/*K
 *
 *	Modul Name......: 
 *
 *	Erstelldatum....: 
 *
 *	Autor...........: 
 *
 *	$Revision: 1.2 $ $Date: 2004/02/13 17:48:49 $
 *
 *      Copyright (c) 1988-91 ABB Installationen GmbH
 *      D-W-6802 Ladenburg, Wallstadter Str. 59
 *
 */


//#ifdef PC
//#define	readonly
//#endif

/*   da readonly nicht compatibel mit const (CAD_UL Compiler)
*    musste im C- Source alle readonly durch entspr. const 
*    ersetzt werden Oestrich 4.8.92  
*    #define	readonly const 
*/

/* Adress-Operationen  */

//#define  ref      &                  	/* Adressoperator  */
//#define  cont     *                  	/* Inhaltsoperator  */
// #define  ptr      *                  	/* Pointer  */

/* Bitoperationen  */

#define  band     &
#define  bor      |
#define  bxor     ^
#define  bnot     ~

/* Vergleichsoperationen  */

#define  ne       !=       
#define  eq       ==                 
#define  and      &&
#define  or       ||
#define  not      !

/* Modulo-operation             */
/* Modulo-Operation  */
#define  mod      %

/* Konstanten  */
/* fuer Null-Zeiger  */
#define  ZERO     0

/* Kontrolldefinitionen  */

#define Begin      {
#define End        }
 
#define If         if
#define Then       {
#define Else       } else {
#define Endif      }

#define While      while
#define Do         {
#define Endwhile   }

#define For        for
#define Endfor     }

//#define Switch(c)  switch(c) {
#define Case       break; case
#define Default    break; default
#define Endswitch  }

#define Forever    for(; ;){
#define Endforever }

#define Repeat     do  {
//#define Until(b)       } while(not (b))

/* neue Funktions- bzw. Variablentypen  */

typedef unsigned char byte;
typedef unsigned short word;
typedef unsigned long longword;
typedef unsigned char bool;
enum    boolean { false=0 , true=1 };

