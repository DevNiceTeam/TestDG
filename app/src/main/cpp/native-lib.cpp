#include <jni.h>
#include <string>
#include <map>


using namespace std;

extern "C" JNIEXPORT jobjectArray JNICALL
Java_com_example_myapplication3_MainActivity_stringFromJNI(JNIEnv* env, jobject)
{
    struct spravStruct
    {
        int size = 2;
        string *name = new string[size] {"Андрей", "Дима"}; // имя
        string *num = new string[size]  {"+79459854545","+79009456363"};
    };

    jobjectArray ret;
    //string hello = "Hello from C++";

    spravStruct ss;
    ret= (jobjectArray)env->NewObjectArray(2,
                                           env->FindClass("java/lang/String"),
                                           env->NewStringUTF(""));

    string sName;
    string sTel;
    string dataPrint;
    for (int i = 0; i < ss.size; ++i)
    {
        dataPrint = ss.name[i]+ "= "  + ss.num[i];
        env->SetObjectArrayElement(ret,i,env->NewStringUTF(dataPrint.c_str()));

    }



    return (ret);

//    string telNum;
//    string telNum2;
//
//    map <string,string>sprav = { {"Dima" ,"+79009488888"},
//                                 {"Андрей", "+ 79507765454"}
//
//    };
//    jobjectArray ret;
//    //string hello = "Hello from C++";
//    string dataPrint;
//
//    ret = (jobjectArray)env->NewObjectArray(5,
//                                            env->FindClass("java/lang/String"),
//                                            env->NewStringUTF(""));
//
//
//    for (auto it = sprav.begin(); it != sprav.end(); ++it)
//    {
//            dataPrint = it->first + " : " + it->second;
//            // (*env).SetObjectArrayElement(env,dataPrint.c_str());
//            env->SetObjectArrayElement(ret,2,env->NewStringUTF(dataPrint.c_str()));
//    }
//    return (ret);
}