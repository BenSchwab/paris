package com.airbnb.paris

import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import java.util.*

internal class TypedArrayWrapperImpl constructor(val typedArray: TypedArray) : TypedArrayWrapper {

    /**
     * Unfortunately Android doesn't support reading @null resources from a style resource like it
     * does from an AttributeSet so this trickery is required
     */
    private val NULL_RESOURCE_IDS = HashSet(Arrays.asList(R.anim.null_, R.color.null_, R.drawable.null_))

    override fun isNull(index: Int): Boolean =
            NULL_RESOURCE_IDS.contains(typedArray.getResourceId(index, 0))

    override fun getIndexCount(): Int = typedArray.indexCount

    override fun getIndex(at: Int): Int = typedArray.getIndex(at)

    override fun hasValue(index: Int): Boolean = typedArray.hasValue(index)

    override fun getBoolean(index: Int, defValue: Boolean): Boolean =
            typedArray.getBoolean(index, defValue)

    override fun getColor(index: Int, defValue: Int): Int = typedArray.getColor(index, defValue)

    override fun getColorStateList(index: Int): ColorStateList = typedArray.getColorStateList(index)

    override fun getDimensionPixelSize(index: Int, defValue: Int): Int =
            typedArray.getDimensionPixelSize(index, defValue)

    override fun getDrawable(index: Int): Drawable = typedArray.getDrawable(index)

    override fun getFloat(index: Int, defValue: Float): Float = typedArray.getFloat(index, defValue)

    override fun getFraction(index: Int, base: Int, pbase: Int, defValue: Float): Float =
            typedArray.getFraction(index, base, pbase, defValue)

    override fun getInt(index: Int, defValue: Int): Int = typedArray.getInt(index, defValue)

    override fun getLayoutDimension(index: Int, defValue: Int): Int =
            typedArray.getLayoutDimension(index, defValue)

    override fun getResourceId(index: Int, defValue: Int): Int =
            if (isNull(index)) 0 else typedArray.getResourceId(index, 0)

    override fun getString(index: Int): String = typedArray.getString(index)

    override fun getText(index: Int): CharSequence = typedArray.getText(index)

    override fun getTextArray(index: Int): Array<CharSequence> = typedArray.getTextArray(index)

    override fun recycle() {
        typedArray.recycle()
    }
}