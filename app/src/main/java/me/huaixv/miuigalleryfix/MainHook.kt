package me.huaixv.miuigalleryfix


// log
import android.util.Log
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

class MainHook : IXposedHookLoadPackage {
    companion object {
        const val VERBOSE = false // Set to true to enable Xposed logging
    }

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        // 过滤不必要的应用
        if (lpparam.packageName != "com.miui.gallery") return
        // 执行Hook
        hook(lpparam)
    }

    private fun hook(lpparam: XC_LoadPackage.LoadPackageParam) {
//        // test 1

//
//        // test 2
//        try {
//            val mainActivityClazz = XposedHelpers.findClass(
//                "com.miui.gallery.activity.HomePageActivity", lpparam.classLoader
//            )
//            // Hook MainActivity的onCreate方法
//            XposedHelpers.findAndHookMethod(
//                mainActivityClazz, "onCreate", android.os.Bundle::class.java, object : XC_MethodHook() {
//                    override fun afterHookedMethod(param: MethodHookParam) {
//                        // 在MainActivity创建后执行
//                        Toast.makeText(param.thisObject as Activity, "模块加载成功！", Toast.LENGTH_SHORT).show()
//                        XposedBridge.log("Hooked HomePageActivity onCreate method successfully!")
//                    }
//                })
//        } finally {
//
//        }
//
//
//        // test3
//        try {
//            XposedHelpers.findAndHookMethod(
//                "com.miui.gallery.adapter.AlbumDetailAdapter",
//                lpparam.classLoader,
//                "getAllPhotosSelection",
//                object : XC_MethodHook() {
//                    override fun afterHookedMethod(param: MethodHookParam) {
//                        val originalResult = param.result as String
//                        //                    val modifiedResult = "$originalResult" //  AND alias_show_in_homepage == NULL"
//                        val modifiedResult = originalResult.replace(
//                            "alias_hidden = 0 AND ", ""
//                        )
//                        param.result = modifiedResult
//                        XposedBridge.log("Original Result: $originalResult")
//                    }
//                })
//        } finally {
//
//        }
//
//        // test 4
//        try {
//            val pickerClazz = XposedHelpers.findClass(
//                "com.miui.gallery.picker.PickAlbumDetailFragment", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                pickerClazz, "getSelection", object : XC_MethodHook() {
//                    override fun afterHookedMethod(param: MethodHookParam) {
//                        val originalResult = param.result as? String ?: return
//
//                        // log originalResult
//                        XposedBridge.log("Original Result: $originalResult")
//
//                        val modifiedResult = originalResult.replace("alias_hidden = ? AND ", "")
//                        XposedBridge.log("Modified Result: $modifiedResult")
//
//                        param.result = modifiedResult
//                    }
//                })
//        } finally {
//
//        }
//


//
//        // test 6
//        try {
//            val clazz = XposedHelpers.findClass(
//                "com.miui.gallery.provider.album.AlbumManager", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                clazz, "getExcludeAlbumSelection", String::class.java, // parameter 1: String str
//                Boolean::class.javaPrimitiveType, // parameter 2: boolean z
//                Long::class.javaPrimitiveType, // parameter 3: long j
//                object : XC_MethodHook() {
//                    override fun afterHookedMethod(param: MethodHookParam) {
//                        val result = param.result as? String
//                        XposedBridge.log("HiddenAlbumHook: getExcludeAlbumSelection() returned: $result")
//                    }
//                })
//
//
//            XposedBridge.log("AlbumManager : Hook ok")
//
//        } catch (t: Throwable) {
//            XposedBridge.log("HiddenAlbumHook: Hook failed: $t")
//        }
//
//        // test 7
//
//        try {
//            val clazz = XposedHelpers.findClass(
//                "com.miui.gallery.provider.album.AlbumManager", lpparam.classLoader
//            )
//
//            // Hook getExcludeEmptyAlbumSelection(boolean z, boolean z2, boolean z3, boolean z4)
//            XposedHelpers.findAndHookMethod(
//                clazz,
//                "getExcludeEmptyAlbumSelection",
//                Boolean::class.javaPrimitiveType,
//                Boolean::class.javaPrimitiveType,
//                Boolean::class.javaPrimitiveType,
//                Boolean::class.javaPrimitiveType,
//                object : XC_MethodReplacement() {
//                    override fun replaceHookedMethod(param: XC_MethodHook.MethodHookParam): Any {
//                        XposedBridge.log("HiddenAlbumHook: getExcludeEmptyAlbumSelection() hooked, returning empty string")
//                        return ""
//                    }
//                })
//
//        } catch (t: Throwable) {
//            XposedBridge.log("HiddenAlbumHook: Hook failed: $t")
//        }
//
//
//        // test 8
//        try {
//            val clazz = XposedHelpers.findClass(
//                "com.miui.gallery.model.dto.Album", lpparam.classLoader
//            )
//
//            // Hook getHiddenAttributeFromDescription(JSONObject)
//            XposedHelpers.findAndHookMethod(
//                clazz, "getHiddenAttributeFromDescription", JSONObject::class.java, object : XC_MethodReplacement() {
//                    override fun replaceHookedMethod(param: MethodHookParam): Any {
//                        XposedBridge.log("HiddenAlbumHook: getHiddenAttributeFromDescription() hooked, return false")
//                        return false
//                    }
//                })
//
//            // Hook getHiddenManualAttributeFromDescription(JSONObject)
//            XposedHelpers.findAndHookMethod(
//                clazz,
//                "getHiddenManualAttributeFromDescription",
//                JSONObject::class.java,
//                object : XC_MethodReplacement() {
//                    override fun replaceHookedMethod(param: MethodHookParam): Any {
//                        XposedBridge.log("HiddenAlbumHook: getHiddenManualAttributeFromDescription() hooked, return false")
//                        return false
//                    }
//                })
//
//            XposedBridge.log("HiddenAlbumHook: Both Album attribute methods hooked successfully")
//
//        } catch (t: Throwable) {
//            XposedBridge.log("HiddenAlbumHook: Hook failed: $t")
//        }
//
//        // test
//
//        try {
//            val clazz = XposedHelpers.findClass(
//                "com.miui.gallery.provider.GalleryProvider", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                clazz,
//                "query",
//                Uri::class.java,
//                Array<String>::class.java,
//                String::class.java,
//                Array<String>::class.java,
//                String::class.java,
//                CancellationSignal::class.java,
//                object : XC_MethodHook() {
//                    override fun beforeHookedMethod(param: MethodHookParam) {
//                        return
//
//                        val uri = param.args[0] as? Uri
//                        val projection = param.args[1] as? Array<*>
//                        val selection = param.args[2] as? String
//                        val selectionArgs = param.args[3] as? Array<*>
//                        val sortOrder = param.args[4] as? String
//                        val cancellationSignal = param.args[5] as? CancellationSignal
//
//                        XposedBridge.log("GalleryProvider.query() called:")
//                        XposedBridge.log("  uri = $uri")
//
//                        XposedBridge.log(
//                            "  query parameter = ${
//                                uri?.getQueryParameter(
//                                    "query_flags"
//                                )
//                            }"
//                        )
//                        XposedBridge.log("  projection = ${projection?.joinToString()}")
//                        XposedBridge.log("  selection = $selection")
//                        XposedBridge.log("  selectionArgs = ${selectionArgs?.joinToString()}")
//                        XposedBridge.log("  sortOrder = $sortOrder")
//                        XposedBridge.log("  cancellationSignal = $cancellationSignal")
//                    }
//                })
//
//            XposedBridge.log("Hooked GalleryProvider.query() successfully.")
//        } catch (t: Throwable) {
//            XposedBridge.log("Failed to hook GalleryProvider.query(): ${t.message}")
//        }
//
//
//        // test
//
//
//        try {
//            val clazz = XposedHelpers.findClass(
//                "com.miui.gallery.provider.RecentDiscoveryMediaManager", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                clazz, "isInShowHiddenMode", object : XC_MethodReplacement() {
//                    override fun replaceHookedMethod(param: MethodHookParam): Any {
//                        XposedBridge.log("Hooked isInShowHiddenMode(): always return true")
//                        return true
//                    }
//                })
//
//            XposedBridge.log("Successfully hooked RecentDiscoveryMediaManager.isInShowHiddenMode()")
//        } catch (t: Throwable) {
//            XposedBridge.log("Failed to hook isInShowHiddenMode(): ${t.message}")
//        }
//
//
//        // test
////
////        try {
////            val clazz = XposedHelpers.findClass(
////                "androidx.sqlite.db.SupportSQLiteQueryBuilder", lpparam.classLoader
////            )
////
////            XposedHelpers.findAndHookMethod(
////                clazz, "builder", String::class.java, object : XC_MethodHook() {
////                    override fun beforeHookedMethod(param: MethodHookParam) {
////                        var arg = param.args[0] as? String ?: "(null)"
////
////                        // Apply removal of unwanted patterns
////                        arg = arg.replace("(attributes & 16 = 0) AND ", "")
////                        arg = arg.replace("attributes&16=0 AND ", "")
////
////                        // Split long string for safe logging
////                        if (arg.length > 150) {
////                            XposedBridge.log("Sanitized SupportSQLiteQueryBuilder.builder() arg (length=${arg.length}):")
////                            arg.chunked(150).forEachIndexed { index, chunk ->
////                                XposedBridge.log("  [Part ${index + 1}] $chunk")
////                            }
////                        } else {
////                            XposedBridge.log("Sanitized SupportSQLiteQueryBuilder.builder() arg: $arg")
////                        }
////                    }
////                })
////
////            XposedBridge.log("Successfully hooked SupportSQLiteQueryBuilder.builder()")
////        } catch (t: Throwable) {
////            XposedBridge.log("Failed to hook SupportSQLiteQueryBuilder.builder(): ${t.message}")
////        }
////
//
//
//
//        try {
//            val clazz = XposedHelpers.findClass(
//                "com.miui.gallery.provider.cache.AlbumCacheItem", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                clazz, "transform", object : XC_MethodHook() {
//                    override fun beforeHookedMethod(param: MethodHookParam) {
//                        val `thisObject` = param.thisObject
//
//                        try {
//                            val dirPath = XposedHelpers.getObjectField(`thisObject`, "mDirectoryPath") as? String
//                            val albumName = XposedHelpers.getObjectField(`thisObject`, "mName") as? String
//                            XposedBridge.log("AlbumCacheItem.transform() called:")
//                            XposedBridge.log("  Name = $albumName")
//                            XposedBridge.log("  DirectoryPath = $dirPath")
//                        } catch (e: Throwable) {
//                            XposedBridge.log("Error while reading AlbumCacheItem fields in transform(): ${e.message}")
//                        }
//                    }
//                })
//
//            XposedBridge.log("Successfully hooked AlbumCacheItem.transform()")
//        } catch (t: Throwable) {
//            XposedBridge.log("Failed to hook AlbumCacheItem.transform(): ${t.message}")
//        }
//
//        // test
//
////        try {
////            val outerClazz = XposedHelpers.findClass(
////                "com.miui.gallery.preference.BaseGalleryPreferences\$Debug", lpparam.classLoader
////            )
////
////            XposedHelpers.findAndHookMethod(
////                outerClazz, "isPrintLog", object : XC_MethodReplacement() {
////                    override fun replaceHookedMethod(param: MethodHookParam): Any {
////                        XposedBridge.log("Hooked isPrintLog(): always return true")
////                        return true
////                    }
////                })
////
////            XposedBridge.log("Successfully hooked BaseGalleryPreferences.Debug.isPrintLog()")
////        } catch (t: Throwable) {
////            XposedBridge.log("Failed to hook BaseGalleryPreferences.Debug.isPrintLog(): ${t.message}")
////        }
//
//
//        // test
//
////        try {
////            val clazz = XposedHelpers.findClass(
////                "com.miui.gallery.ui.album.common.usecase.QueryAlbumsCase\$ParamBean\$Builder",
////                lpparam.classLoader
////            )
////
////            XposedHelpers.findAndHookMethod(
////                clazz,
////                "selection",
////                String::class.java,
////                object : XC_MethodHook() {
////                    override fun beforeHookedMethod(param: MethodHookParam) {
////                        val original = param.args[0] as? String ?: "(null)"
////
////                        // Replace all occurrences of "attributes & 16" with "0"
////                        val sanitized = original.replace("attributes & 16", "0")
////
////                        XposedBridge.log("QueryAlbumsCase.ParamBean.Builder.selection() called with sanitized param:")
////
////                        if (sanitized.length > 256) {
////                            sanitized.chunked(256).forEachIndexed { index, chunk ->
////                                XposedBridge.log("  [Part ${index + 1}] $chunk")
////                            }
////                        } else {
////                            XposedBridge.log("  $sanitized")
////                        }
////
////                        param.args[0] = "TRUE"
////                    }
////                }
////            )
////
////            XposedBridge.log("Successfully hooked QueryAlbumsCase.ParamBean.Builder.selection()")
////        } catch (t: Throwable) {
////            XposedBridge.log("Failed to hook QueryAlbumsCase.ParamBean.Builder.selection(): ${t.message}")
////        }
////
//
//        try {
//            val clazz = XposedHelpers.findClass(
//                "com.miui.gallery.ui.album.common.usecase.QueryAlbumsCase\$ParamBean\$Builder", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                clazz, "selection", String::class.java, object : XC_MethodReplacement() {
//                    override fun replaceHookedMethod(param: MethodHookParam): Any {
//                        val arg = param.args[0] as? String ?: "(null)"
//                        XposedBridge.log("Bypassed selection() call, original param: $arg")
//                        // Directly return 'this' (the Builder instance)
//                        return param.thisObject
//                    }
//                })
//
//            XposedBridge.log("Successfully hooked and bypassed QueryAlbumsCase.ParamBean.Builder.selection()")
//        } catch (t: Throwable) {
//            XposedBridge.log("Failed to hook QueryAlbumsCase.ParamBean.Builder.selection(): ${t.message}")
//        }
//
//        try {
//            val clazz = XposedHelpers.findClass(
//                "com.miui.gallery.model.dto.PageResults", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                clazz, "getResult", object : XC_MethodHook() {
//                    override fun afterHookedMethod(param: MethodHookParam) {
//                        val result = param.result
//
//                        if (result == null) {
//                            XposedBridge.log("PageResults.getResult() returned null")
//                            return
//                        }
//
//                        // Try to cast to List<Album>
//                        if (result is List<*>) {
//                            XposedBridge.log("PageResults.getResult() returned List of size ${result.size}")
//
//                            result.forEachIndexed { index, item ->
//                                try {
//                                    // Use reflection to get Album fields
//                                    val dirPath = XposedHelpers.getObjectField(item, "mDirectoryPath") as? String
//                                    val name = XposedHelpers.getObjectField(item, "mName") as? String
//                                    XposedBridge.log("  [Item $index] Name=$name, DirectoryPath=$dirPath")
//                                } catch (e: Throwable) {
//                                    XposedBridge.log("  [Item $index] Failed to parse item: ${e.message}")
//                                }
//                            }
//
//                            // stack trace
//                            XposedBridge.log(Log.getStackTraceString(Throwable()))
//                        } else {
//                            XposedBridge.log("PageResults.getResult() returned unexpected type: ${result.javaClass.name}")
//                        }
//                    }
//                })
//
//            XposedBridge.log("Successfully hooked PageResults.getResult()")
//        } catch (t: Throwable) {
//            XposedBridge.log("Failed to hook PageResults.getResult(): ${t.message}")
//        }
//
//
//        try {
//            val clazz = XposedHelpers.findClass(
//                "com.miui.gallery.model.datalayer.utils.loader.CustomCursorLoader", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                clazz, "setSelection", String::class.java, object : XC_MethodHook() {
//                    override fun beforeHookedMethod(param: MethodHookParam) {
//                        val original = param.args[0] as? String ?: "(null)"
//                        XposedBridge.log("CustomCursorLoader.setSelection() called with original: $original")
//
//                        // Replace argument with empty string
//                        param.args[0] = null
//                        XposedBridge.log("CustomCursorLoader.setSelection() param forcibly set to empty string")
//                    }
//                })
//
//            XposedBridge.log("Successfully hooked CustomCursorLoader.setSelection()")
//        } catch (t: Throwable) {
//            XposedBridge.log("Failed to hook CustomCursorLoader.setSelection(): ${t.message}")
//        }
//


//        try {
//            val clazz = XposedHelpers.findClass(
//                "com.miui.gallery.provider.cache.AlbumCacheItem", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                clazz, "getId", object : XC_MethodHook() {
//                    override fun beforeHookedMethod(param: MethodHookParam) {
//                        val thisObject = param.thisObject
//
//                        try {
//                            val dirPath = XposedHelpers.getObjectField(thisObject, "mDirectoryPath") as? String
//                            val albumName = XposedHelpers.getObjectField(thisObject, "mName") as? String
//                            val id = XposedHelpers.getObjectField(thisObject, "id") as? Long
//
//                            val attributes = XposedHelpers.getObjectField(thisObject, "mAttributes") as? Long
//                            val mask = (1L shl 4) or (1L shl 5)
//                            val newAttributes = attributes?.and(mask.inv())
//
//                            // unset (1 << 4) bit
//                            XposedHelpers.setObjectField(
//                                thisObject, "mAttributes", newAttributes
//                            )
//
////                            XposedBridge.log("AlbumCacheItem.getId() called:")
////                            XposedBridge.log("  id = $id")
////                            XposedBridge.log("  Name = $albumName")
////                            XposedBridge.log("  DirectoryPath = $dirPath")
//
////                            XposedBridge.log(Log.getStackTraceString(Throwable()))
//                        } catch (e: Throwable) {
//                            XposedBridge.log("Error while reading AlbumCacheItem fields: ${e.message}")
//                        }
//                    }
//                })
//
//            XposedBridge.log("Successfully hooked AlbumCacheItem.getId()")
//        } catch (t: Throwable) {
//            XposedBridge.log("Failed to hook AlbumCacheItem.getId(): ${t.message}")
//        }


//
//        try {
//            val clazz = XposedHelpers.findClass(
//                "com.miui.gallery.ui.album.common.base.BaseAlbumPagePresenter", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                clazz, "isHiddenAlbum", object : XC_MethodReplacement() {
//                    override fun replaceHookedMethod(param: MethodHookParam): Any {
//                        XposedBridge.log("Hooked BaseAlbumPagePresenter.isHiddenAlbum(): always return false")
//                        return false
//                    }
//                })
//
//            XposedBridge.log("Successfully hooked BaseAlbumPagePresenter.isHiddenAlbum()")
//        } catch (t: Throwable) {
//            XposedBridge.log("Failed to hook BaseAlbumPagePresenter.isHiddenAlbum(): ${t.message}")
//        }
//
//
//        try {
//            val threadClass = XposedHelpers.findClass("java.lang.Thread", lpparam.classLoader)
//
//            XposedHelpers.findAndHookMethod(
//                threadClass, "start", object : XC_MethodHook() {
//                    override fun beforeHookedMethod(param: MethodHookParam) {
//                        val thread = param.thisObject as Thread
//                        XposedBridge.log("Thread.start() called:")
//                        XposedBridge.log("  name=${thread.name}")
//                        XposedBridge.log("  id=${thread.id}")
//
//                        // Dump stack trace
//                        val stackTrace = Throwable().stackTrace.joinToString("\n") { "    at $it" }
//                        XposedBridge.log("Thread.start() stacktrace:\n$stackTrace")
//                    }
//                })
//
//            XposedBridge.log("Successfully hooked Thread.start() with stack trace")
//        } catch (e: Throwable) {
//            XposedBridge.log("Failed to hook Thread.start(): ${e.message}")
//        }
//
//        // test
//        try {
//            val queryAlbumsCaseClass = XposedHelpers.findClass(
//                "com.miui.gallery.ui.album.common.usecase.QueryAlbumsCase", lpparam.classLoader
//            )
//
//            val paramBeanClass = XposedHelpers.findClass(
//                "com.miui.gallery.ui.album.common.usecase.QueryAlbumsCase\$ParamBean", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                queryAlbumsCaseClass, "buildFlowable", paramBeanClass, object : XC_MethodHook() {
//                    override fun beforeHookedMethod(param: MethodHookParam) {
//                        try {
//                            val paramBean = param.args[0]
//
//                            XposedBridge.log("QueryAlbumsCase.buildFlowable() called")
//
//                            val clazzParamBean = paramBean.javaClass
//                            for (field in clazzParamBean.declaredFields) {
//                                field.isAccessible = true
//                                val value = field.get(paramBean)
//                                XposedBridge.log("  ${field.name} = $value")
//
//                                // Check and modify mExtraSelection
//                                if (field.name == "mExtraSelection") {
//                                    field.set(paramBean, " 0 = 0 ")
//                                    XposedBridge.log("  -> mExtraSelection modified to ' 0 = 0 '")
//                                }
//                            }
//
//                            // Dump stack trace
//                            val stackTrace = Throwable().stackTrace
//                            for (element in stackTrace) {
//                                XposedBridge.log("    at $element")
//                            }
//
//                        } catch (e: Throwable) {
//                            XposedBridge.log("Error inside buildFlowable hook: ${e.message}")
//                            XposedBridge.log(Log.getStackTraceString(e))
//                        }
//                    }
//                })
//        } catch (e: Throwable) {
//            XposedBridge.log("Failed to hook QueryAlbumsCase.buildFlowable: ${e.message}")
//            XposedBridge.log(Log.getStackTraceString(e))
//        }
//
//
//        try {
//            val albumTableServicesClass = XposedHelpers.findClass(
//                "com.miui.gallery.dao.AlbumTableServices", lpparam.classLoader
//            )
//
//            val queryParamClass = XposedHelpers.findClass(
//                "com.miui.gallery.model.datalayer.repository.album.common.QueryParam", lpparam.classLoader
//            )
//
//
//            // Hook static method: public static final List<Album> queryAlbumSnapDatas(QueryParam queryParam)
//            XposedHelpers.findAndHookMethod(
//                albumTableServicesClass, "queryAlbumSnapDatas", queryParamClass, object : XC_MethodHook() {
//
//                    override fun beforeHookedMethod(param: MethodHookParam) {
//                        try {
//                            val queryParam = param.args[0]
//                            XposedBridge.log("queryAlbumSnapDatas() called with QueryParam:")
//
//                            val clazzQueryParam = queryParam.javaClass
//                            for (field in clazzQueryParam.declaredFields) {
//                                field.isAccessible = true
//                                val value = field.get(queryParam)
//                                XposedBridge.log("  ${field.name} = $value")
//                            }
//
//                        } catch (e: Throwable) {
//                            XposedBridge.log("Error dumping QueryParam: ${e.message}")
//                            XposedBridge.log(Log.getStackTraceString(e))
//                        }
//                    }
//
//                    override fun afterHookedMethod(param: MethodHookParam) {
//                        try {
//                            val result = param.result as? List<*>
//                            XposedBridge.log("queryAlbumSnapDatas() returned list of size: ${result?.size}")
//
//                            if (result != null) {
//                                result.forEachIndexed { index, album ->
//                                    XposedBridge.log("Album[$index]: $album")
//
//                                    // Dump Album fields
//                                    try {
//                                        val clazzAlbum = album?.javaClass
//                                        if (clazzAlbum != null) {
//                                            for (field in clazzAlbum.declaredFields) {
//                                                field.isAccessible = true
//                                                val value = field.get(album)
//                                                XposedBridge.log("  ${field.name} = $value")
//                                            }
//                                        }
//                                    } catch (t: Throwable) {
//                                        XposedBridge.log("  Failed to dump Album fields: ${t.message}")
//                                    }
//                                }
//                            }
//                        } catch (e: Throwable) {
//                            XposedBridge.log("Error dumping result: ${e.message}")
//                            XposedBridge.log(Log.getStackTraceString(e))
//                        }
//                    }
//                })
//
//        } catch (e: Throwable) {
//            XposedBridge.log("Failed to hook queryAlbumSnapDatas: ${e.message}")
//            XposedBridge.log(Log.getStackTraceString(e))
//        }
//
//
//        try {
//            val albumCursorConvertClass = XposedHelpers.findClass(
//                "com.miui.gallery.model.datalayer.utils.AlbumCursorConvert", lpparam.classLoader
//            )
//
//            val cursorClass = XposedHelpers.findClass(
//                "android.database.Cursor", lpparam.classLoader
//            )
//
//            val albumClass = XposedHelpers.findClass(
//                "com.miui.gallery.model.dto.Album", lpparam.classLoader
//            )
//
//            // Hook: public List<Album> convert(Cursor cursor)
//            XposedHelpers.findAndHookMethod(
//                albumCursorConvertClass, "convert", cursorClass, object : XC_MethodHook() {
//
//                    override fun afterHookedMethod(param: MethodHookParam) {
//                        try {
//                            val result = param.result as? List<*>
//                            XposedBridge.log("AlbumCursorConvert.convert() returned list of size: ${result?.size}")
//
//                            if (result != null) {
//                                result.forEachIndexed { index, album ->
//                                    XposedBridge.log("Album[$index]: $album")
//
//                                    // Dump Album fields
//                                    try {
//                                        val clazzAlbum = album?.javaClass
//                                        if (clazzAlbum != null) {
//                                            for (field in clazzAlbum.declaredFields) {
//                                                field.isAccessible = true
//                                                val value = field.get(album)
//                                                XposedBridge.log("  ${field.name} = $value")
//                                            }
//                                        }
//                                    } catch (t: Throwable) {
//                                        XposedBridge.log("  Failed to dump Album fields: ${t.message}")
//                                    }
//                                }
//                            }
//                        } catch (e: Throwable) {
//                            XposedBridge.log("Error dumping result of convert(): ${e.message}")
//                            XposedBridge.log(Log.getStackTraceString(e))
//                        }
//                    }
//                })
//
//        } catch (e: Throwable) {
//            XposedBridge.log("Failed to hook AlbumCursorConvert.convert(): ${e.message}")
//            XposedBridge.log(Log.getStackTraceString(e))
//        }
//
//
//
//        try {
//            val initializeTaskClass = XposedHelpers.findClass(
//                "com.miui.gallery.provider.cache.AlbumCacheManager\$InitializeTask", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                initializeTaskClass, "loadAlbums", object : XC_MethodHook() {
//                    override fun afterHookedMethod(param: MethodHookParam) {
//                        try {
//                            val thisObject = param.thisObject
//
//                            // Access synthetic outer class reference: this$0
//                            val outerField = XposedHelpers.findField(thisObject.javaClass, "this$0")
//                            val albumCacheManager = outerField.get(thisObject)
//
//                            if (albumCacheManager == null) {
//                                XposedBridge.log("AlbumCacheManager is null")
//                                return
//                            }
//
//                            // Access mCache field in AlbumCacheManager
//                            val mCacheField = XposedHelpers.findField(albumCacheManager.javaClass, "mCache")
//                            val mCache = mCacheField.get(albumCacheManager)
//
//                            XposedBridge.log("AlbumCacheManager.mCache = $mCache")
//
//                            // Optional: dump mCache internal fields
//                            if (mCache != null) {
//                                val mCacheClass = mCache.javaClass
//                                for (field in mCacheClass.declaredFields) {
//                                    field.isAccessible = true
//                                    val value = field.get(mCache)
//                                    XposedBridge.log("  mCache.${field.name} = $value")
//                                }
//                            }
//
//                        } catch (e: Throwable) {
//                            XposedBridge.log("Error dumping mCache after loadAlbums: ${e.message}")
//                            XposedBridge.log(Log.getStackTraceString(e))
//                        }
//                    }
//                })
//
//        } catch (e: Throwable) {
//            XposedBridge.log("Failed to hook InitializeTask.loadAlbums(): ${e.message}")
//            XposedBridge.log(Log.getStackTraceString(e))
//        }
//
//
//
//        try {
//            val cacheManagerClass = XposedHelpers.findClass(
//                "com.miui.gallery.provider.cache.CacheManager", lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                cacheManagerClass, "doQuery", String::class.java,            // str
//                Array<String>::class.java,     // strArr
//                String::class.java,            // str2
//                String::class.java,            // str3
//                String::class.java,            // str4
//                object : XC_MethodHook() {
//
//                    override fun beforeHookedMethod(param: MethodHookParam) {
//                        try {
//                            XposedBridge.log("CacheManager.doQuery() called with params:")
//
//                            val str = param.args[0] as String?
//                            val strArr = param.args[1] as Array<String>?
//                            val str2 = param.args[2] as String?
//                            val str3 = param.args[3] as String?
//                            val str4 = param.args[4] as String?
//
//                            XposedBridge.log("  str  = $str")
//                            XposedBridge.log("  str2 = $str2")
//                            XposedBridge.log("  str3 = $str3")
//                            XposedBridge.log("  str4 = $str4")
//
//                            if (strArr != null) {
//                                XposedBridge.log("  strArr: [${strArr.joinToString(", ")}]")
//                            } else {
//                                XposedBridge.log("  strArr: null")
//                            }
//
//                        } catch (e: Throwable) {
//                            XposedBridge.log("Error dumping doQuery params: ${e.message}")
//                            XposedBridge.log(Log.getStackTraceString(e))
//                        }
//                    }
//
//                    override fun afterHookedMethod(param: MethodHookParam) {
//                        try {
//                            val result = param.result as? List<*>
//                            XposedBridge.log("CacheManager.doQuery() returned list of size: ${result?.size}")
//
//                            if (result != null) {
//                                result.forEachIndexed { index, item ->
//                                    if (index > 100) return
//                                    XposedBridge.log("  Result[$index]: $item")
//
//                                    try {
//                                        val itemClass = item?.javaClass
//                                        if (itemClass != null) {
//                                            for (field in itemClass.declaredFields) {
//                                                field.isAccessible = true
//                                                val value = field.get(item)
//                                                XposedBridge.log("    ${field.name} = $value")
//                                            }
//                                        }
//                                    } catch (t: Throwable) {
//                                        XposedBridge.log("    Failed to dump item fields: ${t.message}")
//                                    }
//                                }
//                            }
//
//                            // Dump mCache after query
//                            val thisObject = param.thisObject
//                            val mCacheField = XposedHelpers.findField(thisObject.javaClass, "mCache")
//                            val mCache = mCacheField.get(thisObject)
//
//                            XposedBridge.log("CacheManager.mCache = $mCache")
//
//                            if (mCache != null) {
//                                val mCacheClass = mCache.javaClass
//                                for (field in mCacheClass.declaredFields) {
//                                    field.isAccessible = true
//                                    val value = field.get(mCache)
//                                    XposedBridge.log("  mCache.${field.name} = $value")
//                                }
//                            }
//
//                        } catch (e: Throwable) {
//                            XposedBridge.log("Error dumping doQuery result/mCache: ${e.message}")
//                            XposedBridge.log(Log.getStackTraceString(e))
//                        }
//                    }
//                })
//
//        } catch (e: Throwable) {
//            XposedBridge.log("Failed to hook CacheManager.doQuery(): ${e.message}")
//            XposedBridge.log(Log.getStackTraceString(e))
//        }
//
//
//
//
//        try {
//            val queryFlagsBuilderClass = XposedHelpers.findClass(
//                "com.miui.gallery.provider.album.config.QueryFlagsBuilder",
//                lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookMethod(
//                queryFlagsBuilderClass,
//                "excludeHiddenAlbum",
//                object : XC_MethodReplacement() {
//                    override fun replaceHookedMethod(param: MethodHookParam): Any {
//                        val thisObject = param.thisObject
//                        XposedBridge.log("excludeHiddenAlbum() hooked, directly returning 'this'")
//                        return thisObject
//                    }
//                }
//            )
//
//        } catch (e: Throwable) {
//            XposedBridge.log("Failed to hook excludeHiddenAlbum(): ${e.message}")
//            XposedBridge.log(Log.getStackTraceString(e))
//        }
//
//


//
//        try {
//            val hiddenAlbumItemModelClass = XposedHelpers.findClass(
//                "com.miui.gallery.adapter.itemmodel.HiddenAlbumItemModel",
//                lpparam.classLoader
//            )
//
//
//            val hiddenAlbumItemViewBeanClass = XposedHelpers.findClass(
//                "com.miui.gallery.ui.album.hiddenalbum.viewbean.HiddenAlbumItemViewBean",
//                lpparam.classLoader
//            )
//
//            XposedHelpers.findAndHookConstructor(
//                hiddenAlbumItemModelClass,
//                hiddenAlbumItemViewBeanClass,
//                object : XC_MethodHook() {
//                    override fun beforeHookedMethod(param: MethodHookParam) {
//                        try {
//                            XposedBridge.log("HiddenAlbumItemModel(HiddenAlbumItemViewBean) constructor called")
//
//                            // Dump the argument object
//                            val viewBean = param.args[0]
//                            val viewBeanClass = viewBean?.javaClass
//                            if (viewBeanClass != null) {
//                                for (field in viewBeanClass.declaredFields) {
//                                    field.isAccessible = true
//                                    val value = field.get(viewBean)
//                                    XposedBridge.log("  ${field.name} = $value")
//                                }
//                            }
//
//                            // Dump stack trace
//                            val stackTrace = Throwable().stackTrace
//                            stackTrace.forEach { element ->
//                                XposedBridge.log("  at $element")
//                            }
//                        } catch (e: Throwable) {
//                            XposedBridge.log("Error in HiddenAlbumItemModel constructor hook: ${e.message}")
//                            XposedBridge.log(Log.getStackTraceString(e))
//                        }
//                    }
//                }
//            )
//
//
//        } catch (e: Throwable) {
//            XposedBridge.log("Failed to hook HiddenAlbumItemModel constructor: ${e.message}")
//            XposedBridge.log(Log.getStackTraceString(e))
//        }


        try {
            val clazz = XposedHelpers.findClass(
                "com.miui.gallery.model.datalayer.repository.album.common.datasource.CommonAlbumMemoryDataSourceImpl",
                lpparam.classLoader
            )

            val queryParamClass = XposedHelpers.findClass(
                "com.miui.gallery.model.datalayer.repository.album.common.QueryParam", lpparam.classLoader
            )

            XposedHelpers.findAndHookMethod(
                clazz, "queryAlbums", Long::class.javaPrimitiveType, queryParamClass, object : XC_MethodHook() {

                    override fun beforeHookedMethod(param: MethodHookParam) {
                        try {
                            val jValue = param.args[0] as Long
                            val queryParam = param.args[1]

                            // unset j with 4194304
                            val mask = 4194304L
                            val newJValue = jValue and mask.inv()
                            param.args[0] = newJValue

                            if (VERBOSE) {
                                XposedBridge.log("CommonAlbumMemoryDataSourceImpl.queryAlbums() called:")
                                XposedBridge.log("  j = $newJValue")
                            }

                            // Dump QueryParam fields
                            val clazzQueryParam = queryParam.javaClass
                            for (field in clazzQueryParam.declaredFields) {
                                field.isAccessible = true
                                val value = field.get(queryParam)
                                if (VERBOSE) XposedBridge.log("  QueryParam.${field.name} = $value")
                            }

                        } catch (e: Throwable) {
                            if (VERBOSE) {
                                XposedBridge.log("Error dumping queryAlbums params: ${e.message}")
                                XposedBridge.log(Log.getStackTraceString(e))
                            }
                        }
                    }
                })

        } catch (e: Throwable) {
            if (VERBOSE) {
                XposedBridge.log("Failed to hook queryAlbums: ${e.message}")
                XposedBridge.log(Log.getStackTraceString(e))
            }
        }


        try {
            val albumClass = XposedHelpers.findClass(
                "com.miui.gallery.model.dto.Album",  // adjust if needed
                lpparam.classLoader
            )

            XposedHelpers.findAndHookMethod(
                albumClass, "isHiddenAlbum", object : XC_MethodHook() {
                    override fun beforeHookedMethod(param: MethodHookParam) {
                        try {
                            val stackTrace = Throwable().stackTrace
                            var matchFound = false

                            stackTrace.forEach { element ->
                                val className = element.className
                                if (className.contains("com.miui.gallery.ui.album.main.utils.AlbumGroupByAlbumTypeFunction")) {
                                    matchFound = true
                                    return@forEach
                                }
                            }

                            if (matchFound) {
                                if (VERBOSE) XposedBridge.log("isHiddenAlbum() called from AlbumGroupByAlbumTypeFunction → force return false")
                                param.result = false
                            }

                        } catch (e: Throwable) {
                            if (VERBOSE) {
                                XposedBridge.log("Error inside isHiddenAlbum hook: "+e.message)
                                XposedBridge.log(Log.getStackTraceString(e))
                            }
                        }
                    }
                })
        } catch (e: Throwable) {
            if (VERBOSE) {
                XposedBridge.log("Failed to hook isHiddenAlbum: "+e.message)
                XposedBridge.log(Log.getStackTraceString(e))
            }
        }

    }
}