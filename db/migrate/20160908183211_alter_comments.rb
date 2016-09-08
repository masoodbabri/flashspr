class AlterComments < ActiveRecord::Migration[5.0]
  def change
    rename_column :comments, :activity, :kudo_id
  end
end
