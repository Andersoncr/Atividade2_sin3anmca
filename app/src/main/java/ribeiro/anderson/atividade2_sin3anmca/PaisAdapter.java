package ribeiro.anderson.atividade2_sin3anmca;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

/**
 * Created by Anderson on 19/03/2018.
 */

public class PaisAdapter extends BaseAdapter implements SectionIndexer {
    private Pais[] paises;
    private Activity activity;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;
    private int bandeira;

    public PaisAdapter(Pais[] paises, Activity activity) {
        this.paises = paises;
        this.activity = activity;
        sectionHeaders = SectionIndexBuilder.buildSectionHeaders(paises);
        positionForSectionMap = SectionIndexBuilder.buildPositionForSectionMap(paises);
        sectionForPositionMap = SectionIndexBuilder.buildSectionForPositionMap(paises);
    }

    @Override
    public int getCount() {
        return paises.length;
    }

    @Override
    public Object getItem(int position) {
        return paises[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_pais, parent, false);
            ImageView bandeira = (ImageView) view.findViewById(R.id.foto_pais);
            TextView nome = (TextView) view.findViewById(R.id.texto_nome_pais);
            TextView detalhe = (TextView) view.findViewById(R.id.texto_detalhe_pais);
            ViewHolder viewHolder = new ViewHolder(bandeira, nome, detalhe);
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder)view.getTag();
        viewHolder.getNome().setText(paises[position].getNome());
        viewHolder.getDetalhe().setText(String.format(
                activity.getResources().getString(R.string.lbl_regiao)+
                        " %s - "+
                        activity.getResources().getString(R.string.lbl_capital)+
                        " %s",
                paises[position].getRegiao(),
                paises[position].getCapital()));
        Drawable drawable = Util.getDrawable(activity, paises[position].getCodigo3().toLowerCase());
        if(drawable == null){
            drawable = activity.getDrawable(bandeira);
        }
        viewHolder.getBandeira().setImageDrawable(drawable);

        return view;
    }

    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return positionForSectionMap.get(sectionIndex).intValue();
    }

    @Override
    public int getSectionForPosition(int position) {
        return sectionForPositionMap.get(position).intValue();
    }
}
