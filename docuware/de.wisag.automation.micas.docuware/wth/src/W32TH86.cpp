//---------------------------------------------------------------------------

#include <vcl.h>
#pragma hdrstop
//---------------------------------------------------------------------------
//USEFORM("Unit1.cpp", Form1);
//---------------------------------------------------------------------------
/*---------------------------------------------------------------------------*/


int     WINAPI WMain(HANDLE hInst, HANDLE PInst, LPSTR Cmd, int Show);

WINAPI WinMain (HINSTANCE hInst, HINSTANCE PInst, LPSTR Cmd, int Show)
{
        try
        {
        WMain(hInst, PInst, Cmd, Show);
//                 Application->Initialize();
//                 Application->CreateForm(__classid(TForm1), &Form1);
//                 Application->Run();
        }
        catch (Exception &exception)
        {
        MessageBox (0, "Satz mit X...", "Access Violation", 0);
	//              Application->ShowException(&exception);
        }
        catch (...)
        {
                 try
                 {
                         throw Exception("");
                 }
                 catch (Exception &exception)
                 {
                         Application->ShowException(&exception);
                 }
        }
        return 0;
}


