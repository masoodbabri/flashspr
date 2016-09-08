class UpdateKudo < ActiveRecord::Migration[5.0]
  def change
    add_column :kudos, :author_id, :integer
    add_column :kudos, :category_id, :integer
  end
end
